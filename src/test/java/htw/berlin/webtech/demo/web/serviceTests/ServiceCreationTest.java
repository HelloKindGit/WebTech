package htw.berlin.webtech.demo.web.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;
import htw.berlin.webtech.demo.web.service.RezeptService;
import htw.berlin.webtech.demo.web.service.ZutatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceCreationTest {

    @Autowired
    private RezeptService rService;

    @Autowired
    private ZutatService zService;

    @Test
    public void rServiceLoads() {
        assertThat(rService).isNotNull();
    }

    @Test
    public void zServiceLoads() {
        assertThat(zService).isNotNull();
    }
}
