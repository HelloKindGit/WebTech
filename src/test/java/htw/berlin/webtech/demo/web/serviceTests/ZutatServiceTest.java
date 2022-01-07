package htw.berlin.webtech.demo.web.serviceTests;

import htw.berlin.webtech.demo.web.model.Rezept;
import htw.berlin.webtech.demo.web.model.Zutat;
import htw.berlin.webtech.demo.web.model.ZutatModel;
import htw.berlin.webtech.demo.web.repository.RezeptRepository;
import htw.berlin.webtech.demo.web.service.ZutatService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.util.Optional;

/*
DOES NOT WORK FOR GITHUB-ACTIONS
@SpringBootTest
public class ZutatServiceTest {

    @Autowired
    private ZutatService zService;

    @MockBean
    private RezeptRepository repository;

    @Test
    @DisplayName("sollte ein Rezept über eine eine rezeptId und zutatId finden")
    void rezeptGet() throws Exception {
        Rezept rezept = new Rezept();
        rezept.setId(1L);
        Zutat zutat1 = new Zutat();
        zutat1.setId(2L);
        Zutat zutat2 = new Zutat();
        zutat1.setId(3L);
        Zutat zutat3 = new Zutat();
        zutat1.setId(4L);

        rezept.addZutat(zutat1);
        rezept.addZutat(zutat2);
        rezept.addZutat(zutat3);

        doReturn(Optional.of(rezept)).when(repository).findById(anyLong());

        ZutatModel zutatModel = zService.getZutatByRezeptIdAndId(1L, 4L);

        assertEquals(Long.valueOf(4L), zutatModel.getId());
        assertEquals(Long.valueOf(1L), zutatModel.getRecipeId());
        verify(repository, times(1)).findById(anyLong());
    }

}
*/
