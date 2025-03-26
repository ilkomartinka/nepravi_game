package test;

import command.PrintMapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import svet.Svet;

/**
 * Testovací třída pro příkaz PrintMapa.
 */
public class PrintMapaTest {

    private PrintMapa printMapa;

    @BeforeEach
    public void setUp() {
        Svet svet = new Svet();
        printMapa = new PrintMapa();
        printMapa.set(null, svet);
    }

    @Test
    public void testExecuteWithNoSvet() {
        printMapa.set(null,null);
        IllegalStateException thrown;
        thrown = assertThrows(IllegalStateException.class, () -> {
            printMapa.execute();
        });
        assertEquals("Svet není nastaven. Mapa nemůže být zobrazená.", thrown.getMessage());
    }
}



