package htw.berlin.webtech.demo.web.modelTests;

import htw.berlin.webtech.demo.web.model.ZutatModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ZutatModelTest {

    Long id = 1L;
    Long recipeId = 1L;
    String name = "ZutatModel";
    BigDecimal menge = BigDecimal.valueOf(100);

    @Test
    @DisplayName("Es sollte der richtige String ausgegeben werden")
    void toStringTest() {

        ZutatModel zutatModel = new ZutatModel(id, recipeId, name, menge);

        String expected = "ZutatModel{id=1, recipeId=1, name='ZutatModel', menge=100}";

        String actual = zutatModel.toString();

        Assertions.assertEquals(expected, actual);
    }
}
