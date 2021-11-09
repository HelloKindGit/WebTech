package htw.berlin.webtech.demo.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
public class RezeptServiceTest {

    @Autowired
    private RezeptService service;

    @MockBean
    private RezeptRepository repository;

    @Test
    @DisplayName("sollte ein Rezept über eine id finden")
    void rezeptGet() {
        var r1 = new Rezept("Gulasch mit Rotkohl");
        var r2 = new Rezept("Schweinebraten mit Sauerkraut");

        doReturn(Optional.of(r1)).when(repository).findById(42L);

        Rezept actual = service.getRezeptById(42L);

        assertEquals(actual.getName(), "Gulasch mit Rotkohl");
    }
}
