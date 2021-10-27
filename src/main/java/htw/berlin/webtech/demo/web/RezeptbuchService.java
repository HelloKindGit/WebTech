package htw.berlin.webtech.demo.web;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class RezeptbuchService {

    public List<Rezeptbuch> getRezeptbuch() {
        return List.of(
                new Rezeptbuch(
                        "Festmahl"
                )
        );
    }
}
