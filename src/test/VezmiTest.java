package test;

import command.Vezmi;
import hra.Hrac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import predmety.Klic;
import predmety.Predmet;
import svet.Mistnost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Testovací třída pro příkaz Vezmi.
 */
public class VezmiTest {
    private Hrac hrac;
    private Mistnost mistnost;
    private Predmet predmet;
    private Vezmi vezmi;

    @BeforeEach
    public void setup() {
        hrac = new Hrac();
        predmet = new Klic();
        mistnost = new Mistnost("kuchyn");
        hrac.setAktualniMistnost(mistnost);
        mistnost.pridaniPredmetu("klic", predmet);
        mistnost.setProhledano(true);
        vezmi= new Vezmi();
        vezmi.set(hrac, null);
    }

    @Test
    public void testVezmiPredmet() {
        String vysledek = vezmi.execute();
        assertEquals("Vzal jsi: klic", vysledek);
        assertTrue(hrac.getInventar().contains(predmet.getNazev()));
    }


    @Test
    public void testMistnostNeprohledana() {
        mistnost.setProhledano(false);
        String result = vezmi.execute();
        assertEquals("Nejdriv musis mistnost prohledat", result);
    }

    @Test
    public void testMistnostBezPredmetu() {
        mistnost.odebraniPredmetu();
        String result = vezmi.execute();
        assertEquals("V této místnosti není žádný předmět.", result);
    }
}