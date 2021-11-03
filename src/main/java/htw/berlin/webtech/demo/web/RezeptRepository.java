package htw.berlin.webtech.demo.web;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RezeptRepository extends CrudRepository<Rezept, Long> {

    Optional<Rezept> findRezeptByName(String name);
}
