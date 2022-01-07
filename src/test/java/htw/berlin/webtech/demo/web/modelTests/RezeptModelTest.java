package htw.berlin.webtech.demo.web.modelTests;

import htw.berlin.webtech.demo.web.model.RezeptModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RezeptModelTest {

    String name = "RezeptModel";

    @Test
    @DisplayName("Es sollte der richtige String ausgegeben werden")
    void toStringTest() {

        RezeptModel rezeptModel = new RezeptModel(name);

        String expected = "RezeptModel{name='RezeptModel'}";

        String actual = rezeptModel.toString();

        Assertions.assertEquals(expected, actual);
    }
}
