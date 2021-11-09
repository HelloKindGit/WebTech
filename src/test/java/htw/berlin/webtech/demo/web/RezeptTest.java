package htw.berlin.webtech.demo.web;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RezeptTest {

    @Test
    void rezeptToString() {
        String name = "Schnitzel mit Kartoffelbrei";

        Rezept rezept = new Rezept(name);

        String expected = "Rezept{name='Schnitzel mit Kartoffelbrei'}";

        String actual = rezept.toString();

        assertEquals(expected, actual);
    }
}
