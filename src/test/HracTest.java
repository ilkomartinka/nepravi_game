package test;

import hra.Hrac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import predmety.Klic;
import predmety.Predmet;
import svet.Mistnost;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testovací třída pro Hrac.
 */
public class HracTest {
        private Hrac hrac;
        private Predmet predmet1;
        private Mistnost mistnost;

        @BeforeEach
        void setUp() {
            hrac = new Hrac();
            predmet1 = new Klic();
            mistnost = new Mistnost("kuchyn");
        }

        @Test
        void testDoplneniInventare() {
            hrac.doplneniInventare(predmet1);
            assertTrue(hrac.maPredmet("klic"));
        }

        @Test
        void testNepridaniDuplicitnihoPredmetu() {
            hrac.doplneniInventare(predmet1);
            hrac.doplneniInventare(predmet1);
            assertEquals(1, hrac.vypisInventar().split("-").length - 1);
        }

        @Test
        void testOdebraniPredmetu() {
            hrac.doplneniInventare(predmet1);
            hrac.odebratPredmet(predmet1);
            assertFalse(hrac.maPredmet("klic"));
        }

        @Test
        void testGetPredmet() {
            hrac.doplneniInventare(predmet1);
            assertNotNull(hrac.getPredmet("klic"));
        }

        @Test
        void testSetAktualniMistnost() {
            hrac.setAktualniMistnost(mistnost);
            assertEquals("kuchyn", hrac.getAktualniMistnost().getNazev());
        }
}
