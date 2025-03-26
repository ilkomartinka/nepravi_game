package test;

import command.Pohyb;
import hra.Hrac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import svet.Mistnost;
import svet.Svet;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PohybTest {
    private Hrac hrac;
    private Svet svet;
    private Mistnost mistnost;
    private Pohyb pohyb;

    @BeforeEach
    void setUp() {
        hrac = new Hrac();
        svet = new Svet();
        Scanner sc = new Scanner(System.in);
        mistnost = new Mistnost("");
        pohyb = new Pohyb();
        pohyb.set(hrac, svet);
        Mistnost start = new Mistnost("detska");
        Mistnost cilova = new Mistnost("obyvak");
        hrac.setAktualniMistnost(start);
        start.pridaniMistnosti(cilova.getNazev());
    }

    @Test
    void testPohybDoNezamceneMistnosti() {
        String input = "obyvak\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String vysledek = pohyb.execute();
        assertEquals("Ted se nachazis v -> obyvak", vysledek);
    }

    @Test
    void testPohybDoZamceneMistnostiSeSpravnymHeslem() {
        String input = "sklep\na\n1201\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Mistnost start = new Mistnost("knihovna");
        Mistnost cilova = new Mistnost("sklep");
        start.pridaniMistnosti(cilova.getNazev());
        cilova.setLock(true,"1201");
        hrac.setAktualniMistnost(start);
        svet.getMapa().put("sklep", cilova);
        String vysledek = pohyb.execute();
        assertTrue(vysledek.contains("Ano spravne"));
    }
    @Test
    void testPohybDoZamceneMistnostiSeSpatnymHeslem() {
        String input = "sklep\na\n1234\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Mistnost knihovna = new Mistnost("knihovna");
        Mistnost sklep = new Mistnost("sklep");
        knihovna.pridaniMistnosti(sklep.getNazev());
        sklep.setLock(true,"1201");
        hrac.setAktualniMistnost(knihovna);
        String vysledek = pohyb.execute();
        assertTrue(vysledek.contains("ŠPATNĚ, zkus znova :)"));
    }
}


