package htw.berlin.webtech.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return rezeptRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Rezept addNewRecipe(Rezept rezept) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findRezeptByName(rezept.getName());
        if (rezeptOptional.isPresent()) {
            throw new IllegalStateException("Rezept existiert bereits");
        }
        return rezeptRepository.save(rezept);
    }

    public void deleteRecipe(Long id) {
        boolean exists = rezeptRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Rezept mit angegebener id existiert nicht: " + id);
        }
        rezeptRepository.deleteById(id);
    }

    @Transactional
    public void updateRezept(Long id, String name) {
        Rezept rezept = rezeptRepository.findById(id).orElseThrow(() -> new IllegalStateException("Rezept mit angegebener id existiert nicht: " + id));
        if (name != null && name.length() > 0 && !Objects.equals(rezept.getName(), name)) {
            Optional<Rezept> studentOptional = rezeptRepository.findRezeptByName(name);
            if (studentOptional.isPresent()) throw new IllegalStateException("Name existiert bereits");
            rezept.setName(name);
        }
    }

}
