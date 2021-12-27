package htw.berlin.webtech.demo.web.controller;

import htw.berlin.webtech.demo.web.model.Zutat;
import htw.berlin.webtech.demo.web.model.ZutatModel;
import htw.berlin.webtech.demo.web.service.RezeptService;
import htw.berlin.webtech.demo.web.service.ZutatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/rezepte")
public class ZutatController {

    private final ZutatService zutatService;

    @Autowired
    public ZutatController(ZutatService zutatService) {
        this.zutatService = zutatService;
    }

    @GetMapping("/{rezeptId}/zutaten/all")
    public Set<ZutatModel> getZutatenByRezeptId(@PathVariable String rezeptId) {
        Long rezeptId_ = Long.parseLong(rezeptId);
        return zutatService.getZutatenByRezeptId(rezeptId_);
    }

    @GetMapping("/{rezeptId}/zutaten/{id}")
    public ZutatModel getZutatByRezeptIdAndId(@PathVariable String rezeptId, @PathVariable String id) {
        Long rezeptId_ = Long.parseLong(rezeptId);
        Long id_ = Long.parseLong(id);
        return zutatService.getZutatByRezeptIdAndId(rezeptId_, id_);
    }

    @PostMapping("/{rezeptId}/zutaten")
    public void addZutat(@RequestBody Zutat zutat, @PathVariable String rezeptId) {
        Long rezeptId_ = Long.parseLong(rezeptId);
        zutatService.addZutat(rezeptId_, zutat);
    }

    @DeleteMapping("/{rezeptId}/zutaten/{id}")
    public void deleteZutatById(@PathVariable String rezeptId, @PathVariable String id) {
        Long rezeptId_ = Long.parseLong(rezeptId);
        Long id_ = Long.parseLong(id);
        zutatService.deleteZutatById(rezeptId_, id_);
    }

    @PostMapping("/{rezeptId}/zutaten/{id}")
    public void updateZutat(@RequestBody Zutat zutat, @PathVariable String rezeptId, @PathVariable String id) {
        Long rezeptId_ = Long.parseLong(rezeptId);
        Long id_ = Long.parseLong(id);
        zutatService.updateZutat(rezeptId_, id_, zutat);
    }
}
