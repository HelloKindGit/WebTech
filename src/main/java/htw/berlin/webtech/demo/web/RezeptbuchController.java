package htw.berlin.webtech.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RezeptbuchController {

    private final RezeptbuchService rezeptbuchService;

    @Autowired
    public RezeptbuchController(RezeptbuchService rezeptbuchService) {this.rezeptbuchService = rezeptbuchService;}

    @GetMapping("/rezeptbuch")
    public List<Rezeptbuch> getRezeptbuch() {
        return rezeptbuchService.getRezeptbuch();
    }
}