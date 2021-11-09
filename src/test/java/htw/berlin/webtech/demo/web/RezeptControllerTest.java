package htw.berlin.webtech.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class RezeptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RezeptService service;

    @Test
    public void rezeptGetRoute() throws Exception {

    }
}
