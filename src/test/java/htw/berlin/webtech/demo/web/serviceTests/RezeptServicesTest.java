package htw.berlin.webtech.demo.web.serviceTests;

import htw.berlin.webtech.demo.web.model.Rezept;
import htw.berlin.webtech.demo.web.model.RezeptModel;
import htw.berlin.webtech.demo.web.repository.RezeptRepository;
import htw.berlin.webtech.demo.web.service.RezeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class RezeptServicesTest {

    @Autowired
    private RezeptService service;

    @MockBean
    private RezeptRepository repository;

    @Test
    public void rezeptGetById() {
        var r1 = new Rezept("Gulasch mit Rotkohl");

        doReturn(Optional.of(r1)).when(repository).findById(1L);

        RezeptModel actual = service.getRezeptById(1L);

        assertEquals(actual.getName(), "Gulasch mit Rotkohl");
    }
}
