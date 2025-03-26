package test;

import hra.Hrac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import predmety.*;
import svet.Mistnost;
import command.Pouzij;
import svet.Svet;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class PouzijTest {
    private Hrac hrac;
    private Svet svet;
    private Pouzij pouzij;
    private Mistnost loznice;
    private Mistnost tajna;


    @BeforeEach
    void setUp() {
        hrac = new Hrac();
        svet = new Svet();
        pouzij = new Pouzij();;
        tajna = new Mistnost("tajna");
        tajna.setZamceno(true);
        loznice = new Mistnost("loznice");
        hrac.setAktualniMistnost(loznice);
        hrac.doplneniInventare(new Klic());
        pouzij.set(hrac, svet);
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testPouzitiSimKarty() {
        hrac.doplneniInventare(new SIMkarta());
        hrac.doplneniInventare(new Telefon());
        setInput("SIMkarta");
        String result = pouzij.execute();
        assertEquals("Vložil jsi SIM kartu do mobilu, teď je čas ho využít.", result);
    }

    @Test
    public void testPouzitiPredmetuTelefon() {
       hrac.doplneniInventare(new SIMkarta());
       hrac.doplneniInventare(new Telefon());
        setInput("telefon");
        String result = pouzij.execute();
        assertEquals("Volame pomoc!!!Buď však opatrný, prarodiče si mohou všimnout, že telefonuješ.", result);
    }

    @Test
    public void testPouzitiPredmetuBaterka() {
        setInput("baterka");
        String result = pouzij.execute();
        assertEquals("Zapnul jsi baterku.", result);
    }

    /*@Test
    public void testPouzitiPredmetuKlic() {
        setInput("klic");
        String result = pouzij.execute();
        assertEquals("Použil jsi klíč a otevřel jsi tajnou mistnost.", result);
    }*/
}


