package htw.berlin.webtech.demo.web;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    /*
    private Integer kochzeitInMin;
    private Integer personanAnzahl;
    @ElementCollection
    @CollectionTable(name = "ingredient_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "ingredient")
    private List<String> ingredients;
     */

    public Rezept() {}

    public Rezept(String name) {
        this.name = name;
    }

    public Rezept(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rezept{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rezept rezept = (Rezept) o;
        return Objects.equals(id, rezept.id) && name.equals(rezept.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
