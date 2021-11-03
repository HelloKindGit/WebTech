package htw.berlin.webtech.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RezeptController {

    private final RezeptService rezeptService;

    @Autowired
    public RezeptController(RezeptService rezeptService) {
        this.rezeptService = rezeptService;
    }

    @GetMapping("/rezepte")
    public List<Rezept> getRezepte() {
        return rezeptService.getRezepte();
    }

    @GetMapping("/rezepte/get/{id}")
    public Rezept getRezeptById(@PathVariable String id) {
        Long rezeptId = Long.parseLong(id);
        return rezeptService.getRezeptById(rezeptId);
    }

    @PostMapping("/rezepte/add")
    public Rezept addNewRecipe(@RequestBody Rezept rezept) {
        return rezeptService.addNewRecipe(rezept);
    }

    @DeleteMapping(path = "/rezepte/delete/{id}")
    public void deleteRecipe(@PathVariable String id) {
        Long rezeptId = Long.parseLong(id);
        rezeptService.deleteRecipe(rezeptId);
    }

    @PutMapping(path = "/rezepte/update/{id}")
    public void updateRezept(@PathVariable("id") String id, @RequestParam(required = false) String name) {
        Long rezeptId = Long.parseLong(id);

        rezeptService.updateRezept(rezeptId, name);
    }
}