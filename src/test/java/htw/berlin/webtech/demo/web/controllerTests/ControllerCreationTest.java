package htw.berlin.webtech.demo.web.controllerTests;

import static org.assertj.core.api.Assertions.assertThat;
import htw.berlin.webtech.demo.web.controller.RezeptController;
import htw.berlin.webtech.demo.web.controller.ZutatController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerCreationTest {

    @Autowired
    private RezeptController rController;

    @Autowired
    private ZutatController zController;

    @Test
    @DisplayName("RezeptController sollte erstellt werden")
    public void rControllerLoads() {
        assertThat(rController).isNotNull();
    }

    @Test
    @DisplayName("ZutatController sollte erstellt werden")
    public void zControllerLoads() {
        assertThat(zController).isNotNull();
    }
}
