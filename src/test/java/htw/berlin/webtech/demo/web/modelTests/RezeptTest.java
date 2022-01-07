package htw.berlin.webtech.demo.web.modelTests;

import htw.berlin.webtech.demo.web.model.Rezept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RezeptTest {

    String name = "Rezept";

    @Test
    @DisplayName("Es sollte der richtige String ausgegeben werden")
    void toStringTest() {

        Rezept rezept = new Rezept(name);

        String expected = "Rezept{name='Rezept'}";

        String actual = rezept.toString();

        Assertions.assertEquals(expected, actual);
    }
}
