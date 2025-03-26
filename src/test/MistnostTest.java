package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postavy.NepraviPrarodice;
import postavy.Postava;
import predmety.Klic;
import predmety.Predmet;
import svet.Mistnost;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro Mistnost.
 */
public class MistnostTest {
    private Mistnost kuchyn;
    private Mistnost obyvak;
    private Mistnost mistnost;
    private Postava postava;

    @BeforeEach
    void setup() {
        kuchyn = new Mistnost("kuchyn");
        obyvak = new Mistnost("obyvak");
        Predmet predmet = new Klic();
        postava = new NepraviPrarodice();
        kuchyn.pridaniPredmetu("klic", predmet);
        obyvak.pridatPostavu(postava);
    }

    @Test
    public void testPridaniPredmetu() {
        assertTrue(kuchyn.obsahujePredmet());
        assertEquals(1, kuchyn.getPredmet().size());
    }

    @Test
    public void testOdebraniPredmetu() {
        Predmet odebranyPredmet = kuchyn.odebraniPredmetu();
        assertNotNull(odebranyPredmet);
        assertEquals("klic", odebranyPredmet.getNazev());
        assertFalse(kuchyn.obsahujePredmet());
    }

    @Test
    public void testZamceniMistnosti() {
        mistnost = new Mistnost("tajna");
        mistnost.setLock(true, "klic");
        assertTrue(mistnost.isZamceno());
        assertEquals("klic", mistnost.getPomocnyPredmet());
    }

    @Test
    public void testPridaniPostavy() {
        obyvak.pridatPostavu(postava);
        assertFalse(obyvak.getPostavy().isEmpty());
        assertEquals("Prarodiče", obyvak.getPostava().getJmeno());
        assertTrue(obyvak.getPostavy().contains(postava));
    }

    @Test
    public void testPridaniSousedniMistnosti() {
        mistnost = new Mistnost("detska");
        mistnost.pridaniMistnosti(obyvak.getNazev());
        assertTrue(mistnost.getSousedniMistnosti().contains(obyvak.getNazev()));
    }

    @Test
    public void testProhledaniMistnosti() {
        mistnost = new Mistnost("loznice");
        mistnost.setProhledano(true);
        assertTrue(mistnost.isProhledano());
    }
}

