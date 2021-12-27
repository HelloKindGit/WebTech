package htw.berlin.webtech.demo.web.service;

import htw.berlin.webtech.demo.web.model.Rezept;
import htw.berlin.webtech.demo.web.model.Zutat;
import htw.berlin.webtech.demo.web.model.ZutatModel;
import htw.berlin.webtech.demo.web.model.ZutatToZutatModel;
import htw.berlin.webtech.demo.web.repository.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//Inspiration von:
//https://github.com/mlisitski/spring-boot-recipe-app/blob/master/src/main/java/it/house/recipe/services/IngredientServiceImpl.java
@Service
public class ZutatService {

    private final RezeptRepository rezeptRepository;
    private final ZutatToZutatModel zutatToZutatModel;

    @Autowired
    public ZutatService(RezeptRepository rezeptRepository, ZutatToZutatModel zutatToZutatModel) {
        this.rezeptRepository = rezeptRepository;
        this.zutatToZutatModel = zutatToZutatModel;
    }

    public Set<ZutatModel> getZutatenByRezeptId(Long rezeptId) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findById(rezeptId);

        if (rezeptOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        }

        Rezept rezept = rezeptOptional.get();

        Set<ZutatModel> zutatModel = rezept.getZutaten().stream()
                .map(zutatToZutatModel::convert).collect(Collectors.toSet());

        if (zutatModel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Keine Zutaten für dieses Rezept gefunden!");
        }

        return zutatModel;
    }

    public ZutatModel getZutatByRezeptIdAndId(Long rezeptId, Long id) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findById(rezeptId);

        if (rezeptOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        }

        Rezept rezept = rezeptOptional.get();

        Optional<ZutatModel> zutatModelOptional = rezept.getZutaten().stream()
                .filter(zutat -> zutat.getId().equals(id))
                .map(zutatToZutatModel::convert).findFirst();

        if (zutatModelOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zutat mit dieser Id wurde nicht gefunden!");
        }


        return zutatModelOptional.get();
    }

    public void addZutat(Long rezeptId, Zutat zutat) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findById(rezeptId);

        if (rezeptOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        } else {
            Rezept rezept = rezeptOptional.get();

            Optional<Zutat> zutatOptional = rezept
                    .getZutaten()
                    .stream()
                    .filter(ingredient -> ingredient.getName().equals(zutat.getName()))
                    .findFirst();

            if (zutatOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zutat existiert bereits");
            } else {
                zutat.setRezept(rezept);
                rezept.addZutat(zutat);
            }

            rezeptRepository.save(rezept);
        }
    }

    public void deleteZutatById(Long rezeptId, Long id) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findById(rezeptId);

        if (rezeptOptional.isPresent()) {
            Rezept rezept = rezeptOptional.get();

            Optional<Zutat> zutatOptional = rezept
                    .getZutaten()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(id))
                    .findFirst();

            if (zutatOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zutat mit dieser ID wurde nicht gefunden!");
            } else {
                Zutat zutatDeleted = zutatOptional.get();
                rezept.deleteZutat(zutatDeleted);
                rezeptRepository.save(rezept);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser ID wurde nicht gefunden");
        }
    }

    public void updateZutat(Long rezeptId, Long id, Zutat zutat) {
        Optional<Rezept> rezeptOptional = rezeptRepository.findById(rezeptId);

        if (rezeptOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezept mit dieser Id wurde nicht gefunden!");
        } else {
            Rezept rezept = rezeptOptional.get();

            Optional<Zutat> zutatOptional = rezept
                    .getZutaten()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(id))
                    .findFirst();

            if (zutatOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zutat mit dieser Id wurde nicht gefunden!");
            } else {
                Zutat zutatGefunden = zutatOptional.get();
                rezept.deleteZutat(zutatGefunden);
                zutatGefunden.setName(zutat.getName());
                zutatGefunden.setMenge(zutat.getMenge());
                zutatGefunden.setRezept(rezept);
                rezept.addZutat(zutatGefunden);
                rezeptRepository.save(rezept);
            }
        }
    }

}
