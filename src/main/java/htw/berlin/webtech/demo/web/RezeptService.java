package htw.berlin.webtech.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RezeptService {

    private final RezeptRepository rezeptRepository;

    @Autowired
    public RezeptService(RezeptRepository rezeptRepository) {
        this.rezeptRepository = rezeptRepository;
    }

    public List<Rezept> getRezepte() {
        return (List<Rezept>) rezeptRepository.findAll();
    }

    public Rezept getRezeptById(Long id) {
        return rezeptRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!"));
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
        rezeptRepository.save(rezeptEnitity);

        /*
        Rezept rezept = rezeptRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!"));
        if (name != null && name.length() > 0 && !Objects.equals(rezept.getName(), name)) {
            Optional<Rezept> studentOptional = rezeptRepository.findRezeptByName(name);
            if (studentOptional.isPresent())
                throw new IllegalStateException("Rezept mit diesem Namen existiert bereits");
            rezept.setName(name);
        }
         */
    }
}
