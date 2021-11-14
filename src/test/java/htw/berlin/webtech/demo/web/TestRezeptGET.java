package htw.berlin.webtech.demo.web;

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
public class TestRezeptGET {

    private static final String REZEPTNAME = "Kartoffelbrei mit Fischstäbchen";

    @Autowired
    private RezeptRepository repository;

    @BeforeEach
    public void addProductsToDb() {
        Rezept rezept = new Rezept();
        rezept.setName(REZEPTNAME);
        repository.save(rezept);
    }

    @AfterEach
    public void clearProductDb() {
        repository.deleteAll();
    }

    @Test
    public void getRequest() throws Exception {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<Rezept> productEntity = restTemplate.getForEntity("http://localhost:8080/api/rezepte/1", Rezept.class);
        Assertions.assertEquals(productEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(productEntity.getBody());
        Assertions.assertEquals(productEntity.getBody().getName(), REZEPTNAME);
    }
}
