package htw.berlin.webtech.demo.web.service;

import htw.berlin.webtech.demo.web.model.RezeptModel;
import htw.berlin.webtech.demo.web.model.RezeptZuRezeptModel;
import htw.berlin.webtech.demo.web.model.ZutatModel;
import htw.berlin.webtech.demo.web.repository.RezeptRepository;
import htw.berlin.webtech.demo.web.model.Rezept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RezeptService {

    private final RezeptRepository rezeptRepository;
    private final RezeptZuRezeptModel rezeptZuRezeptModel;

    @Autowired
    public RezeptService(RezeptRepository rezeptRepository, RezeptZuRezeptModel rezeptZuRezeptModel) {
        this.rezeptRepository = rezeptRepository;
        this.rezeptZuRezeptModel = rezeptZuRezeptModel;
    }

    public Set<RezeptModel> getRezepte() {
        Set<Rezept> rezepte = new HashSet<>();
        rezeptRepository.findAll().iterator().forEachRemaining(rezepte::add);

        if (rezepte.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Keine Rezepte gefunden");
        }

        return rezepte.stream().map(rezeptZuRezeptModel::convert).collect(Collectors.toSet());
    }

    public RezeptModel getRezeptById(Long id) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findById(id);
        if (rezeptOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        }
        Rezept rezept = rezeptOptional.get();

        return rezeptZuRezeptModel.convert(rezept);
    }

    public Rezept addNewRecipe(Rezept rezept) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findRezeptByName(rezept.getName());
        if (rezeptOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Rezept mit diesem Namen existiert bereits!");
        }
        return rezeptRepository.save(rezept);
    }

    public void deleteRecipe(Long id) {
        boolean exists = rezeptRepository.existsById(id);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        }
        rezeptRepository.deleteById(id);
    }

    @Transactional
    public void updateRezept(Long id, Rezept rezept) {
        var rezeptOptional = rezeptRepository.findById(id);
        if (rezeptOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        }
        var rezeptEnitity = rezeptOptional.get();
        rezeptEnitity.setName(rezept.getName());
        rezeptEnitity.setBeschreibung(rezept.getBeschreibung());
        rezeptEnitity.setVorbereitungsZeit(rezept.getVorbereitungsZeit());
        rezeptEnitity.setKochZeit(rezept.getKochZeit());
        rezeptEnitity.setPortionen(rezept.getPortionen());
        rezeptRepository.save(rezeptEnitity);
    }
}
