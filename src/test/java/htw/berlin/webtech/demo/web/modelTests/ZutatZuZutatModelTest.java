package htw.berlin.webtech.demo.web.modelTests;

import htw.berlin.webtech.demo.web.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ZutatZuZutatModelTest {

    @Autowired
    ZutatToZutatModel zzzModel;

    Long id = 1L;
    Long recipeId = 2L;
    String name = "Rezept";
    BigDecimal menge = BigDecimal.valueOf(100);

    @Test
    @DisplayName("Zutat sollte zu ZutatModel konvertiert werden")
    void convertTest() {
        Rezept rezept = new Rezept(recipeId);
        Zutat zutat = new Zutat(id, name, menge);
        zutat.setRezept(rezept);

        var expected = zzzModel.convert(zutat);

        ZutatModel actual = new ZutatModel(id, recipeId, name, menge);

        assert expected != null;
        Assertions.assertEquals(expected.getClass(), actual.getClass());
    }
}
