package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import svet.Svet;
import svet.Mistnost;
import postavy.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SvetTest {

    private Svet svet;

    @BeforeEach
    void setUp() {
            svet = new Svet();
    }

    @Test
    void testNacteniMapy() {   //nevim jestli mam overit kazdou mistnost
        assertTrue(svet.getMapa().containsKey("detska"));
        assertTrue(svet.getMapa().get("detska").getSousedniMistnosti().contains("obyvak"));
        assertTrue(svet.getMapa().containsKey("obyvak"));
        assertTrue(svet.getMapa().get("obyvak").getSousedniMistnosti().contains("koupelna"));
        assertTrue(svet.getMapa().get("obyvak").getSousedniMistnosti().contains("detska"));
        assertTrue(svet.getMapa().containsKey("kuchyn"));
        assertTrue(svet.getMapa().get("kuchyn").getSousedniMistnosti().contains("chodba"));
        assertTrue(svet.getMapa().containsKey("sklep"));
        assertTrue(svet.getMapa().get("sklep").getSousedniMistnosti().contains("knihovna"));
    }

    @Test
    void testPridaniPredmetu() {
        assertTrue(svet.getMapa().get("kuchyn").getPredmet().containsKey("klic"));
        assertTrue(svet.getMapa().get("detska").getPredmet().containsKey("baterka"));
        assertTrue(svet.getMapa().get("sklep").getPredmet().containsKey("telefon"));
        assertTrue(svet.getMapa().get("loznice").getPredmet().containsKey("denik"));
        assertTrue(svet.getMapa().get("koupelna").getPredmet().containsKey("SIMkarta"));
    }

    @Test
    void testPridaniPostav() {
        assertTrue(svet.getMapa().get("sklep").getPostavy().stream().anyMatch(postava -> postava instanceof PraviPrarodice));
        assertTrue(svet.getMapa().get("obyvak").getPostavy().stream().anyMatch(postava -> postava instanceof NepraviPrarodice));
        assertTrue(svet.getMapa().get("detska").getPostavy().stream().anyMatch(postava -> postava instanceof Segra));
    }

    @Test
    void testNajdiSegru() {
        Segra segra = svet.najdiSegru();
        assertNotNull(segra, "Metoda 'najdiSegru' by měla vrátit postavu 'Segra'.");
    }

    @Test
    void testPresunSegru() {
        Mistnost novaMistnost = svet.getMapa().get("kuchyn");
        svet.presunSegru(novaMistnost);
        assertEquals(novaMistnost, svet.najdiSegru().getPoloha());
    }

    @Test
    void testNajdiPravePrarodice() {
        PraviPrarodice praviPrarodice = svet.najdiPravePrarodice();
        assertNotNull(praviPrarodice, "Metoda by měla vrátit postavu PraviPrarodice.");
    }
}

