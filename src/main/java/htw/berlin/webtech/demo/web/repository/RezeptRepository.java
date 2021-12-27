package htw.berlin.webtech.demo.web.repository;

import htw.berlin.webtech.demo.web.model.Rezept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RezeptRepository extends CrudRepository<Rezept, Long> {

    Optional<Rezept> findRezeptByName(String name);
}
