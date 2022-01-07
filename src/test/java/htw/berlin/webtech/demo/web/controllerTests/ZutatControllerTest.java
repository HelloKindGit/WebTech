package htw.berlin.webtech.demo.web.controllerTests;

import htw.berlin.webtech.demo.web.model.Rezept;
import htw.berlin.webtech.demo.web.model.Zutat;
import htw.berlin.webtech.demo.web.repository.RezeptRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ZutatControllerTest {

    private static final String REZEPTNAME = "Kartoffelbrei mit Fischstäbchen";
    private static final String ZUTATNAME = "Kartoffeln";

    @Autowired
    private RezeptRepository repository;

    @BeforeEach
    public void addRezeptUndZutat() {
        Zutat zutat = new Zutat();
        zutat.setName(ZUTATNAME);
        Rezept rezept = new Rezept();
        rezept.setName(REZEPTNAME);
        rezept.addZutat(zutat);
        repository.save(rezept);
    }

    @AfterEach
    public void clearRezeptUndZutat() {
        repository.deleteAll();
    }

    @Test
    public void getRequest() throws Exception {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<Zutat> productEntity = restTemplate.getForEntity("http://localhost:8080/api/rezepte/1/zutaten/1", Zutat.class);
        Assertions.assertEquals(productEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(productEntity.getBody());
        Assertions.assertEquals(productEntity.getBody().getName(), ZUTATNAME);
    }
}
