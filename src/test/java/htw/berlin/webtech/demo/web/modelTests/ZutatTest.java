package htw.berlin.webtech.demo.web.modelTests;

import htw.berlin.webtech.demo.web.model.Zutat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ZutatTest {

    String name = "Zutat";
    BigDecimal menge = BigDecimal.valueOf(150);

    @Test
    @DisplayName("Es sollte der richtige String ausgegeben werden")
    void toStringTest() {

        Zutat zutat = new Zutat(name, menge);
        zutat.setId(1L);

        String expected = "Zutat{id=1, name='Zutat', menge=150}";

        String actual = zutat.toString();

        Assertions.assertEquals(expected, actual);
    }
}
