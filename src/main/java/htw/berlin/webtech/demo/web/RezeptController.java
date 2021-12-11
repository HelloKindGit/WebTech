package htw.berlin.webtech.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rezepte")
public class RezeptController {

    private final RezeptService rezeptService;

    @Autowired
    public RezeptController(RezeptService rezeptService) {
        this.rezeptService = rezeptService;
    }

    @GetMapping("/all")
    public List<Rezept> getRezepte() {
        return rezeptService.getRezepte();
    }

    @GetMapping("{id}")
    public Rezept getRezeptById(@PathVariable String id) {
        Long rezeptId = Long.parseLong(id);
        return rezeptService.getRezeptById(rezeptId);
    }

    @PostMapping("")
    public Rezept addNewRecipe(@RequestBody Rezept rezept) {
        return rezeptService.addNewRecipe(rezept);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteRecipe(@PathVariable String id) {
        Long rezeptId = Long.parseLong(id);
        rezeptService.deleteRecipe(rezeptId);
    }

    @PutMapping(path = "/{id}")
    public void updateRezept(@PathVariable("id") String id, @RequestBody Rezept rezept) {
        Long rezeptId = Long.parseLong(id);
        rezeptService.updateRezept(rezeptId, rezept);
    }
}
