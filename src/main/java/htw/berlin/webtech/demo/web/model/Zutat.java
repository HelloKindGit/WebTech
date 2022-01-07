package htw.berlin.webtech.demo.web.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Zutat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal menge;

    @ManyToOne
    private Rezept rezept;

    public Zutat() {
    }

    public Zutat(String name, BigDecimal menge) {
        this.name = name;
        this.menge = menge;
    }

    public Zutat(Long id, String name, BigDecimal menge) {
        this.id = id;
        this.name = name;
        this.menge = menge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMenge() {
        return menge;
    }

    public void setMenge(BigDecimal menge) {
        this.menge = menge;
    }

    public Rezept getRezept() {
        return rezept;
    }

    public void setRezept(Rezept rezept) {
        this.rezept = rezept;
    }

    @Override
    public String toString() {
        return "Zutat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menge=" + menge +
                '}';
    }
}
