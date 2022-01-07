package htw.berlin.webtech.demo.web.modelTests;

import htw.berlin.webtech.demo.web.model.Rezept;
import htw.berlin.webtech.demo.web.model.RezeptModel;
import htw.berlin.webtech.demo.web.model.RezeptZuRezeptModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RezeptZuRezeptModelTest {

    @Autowired
    RezeptZuRezeptModel rzrModel;

    String name = "Rezept";

    @Test
    @DisplayName("Rezept sollte zu RezeptModel konvertiert werden")
    void convertTest() {
        Rezept rezept = new Rezept(name);

        var expected = rzrModel.convert(rezept);

        RezeptModel actual = new RezeptModel(name);

        assert expected != null;
        Assertions.assertEquals(expected.getClass(), actual.getClass());
    }
}
