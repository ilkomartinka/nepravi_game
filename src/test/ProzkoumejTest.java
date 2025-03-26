package test;

import command.Prozkoumej;
import hra.Hrac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import predmety.Klic;
import svet.Mistnost;
import svet.Svet;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testovací třída pro příkaz Prozkoumej.
 */
class ProzkoumejTest {
    private Hrac hrac;
    private Mistnost mistnost;
    private Prozkoumej prozkoumej;
    private Svet svet;

    @BeforeEach
    void setUp() {
        hrac = new Hrac();
        svet = new Svet();
        mistnost = new Mistnost("kuchyn");
        hrac.setAktualniMistnost(mistnost);
        mistnost.pridaniPredmetu("klic",new Klic());
        prozkoumej = new Prozkoumej();
        prozkoumej.set(hrac,svet);
    }

    @Test
    void testProzkoumejMistnostSPredmetem() {
        String result = prozkoumej.execute();
        assertTrue(result.contains("Nalezen novy predmet -> "));
        assertTrue(result.contains("klic"));
    }

    @Test
    void testProzkoumejPrazdnouMistnost() {
        mistnost = new Mistnost("chodba");
        hrac.setAktualniMistnost(mistnost);
        String result = prozkoumej.execute();
        assertEquals("Zadny predmet nebyl nelezen", result);
    }
}