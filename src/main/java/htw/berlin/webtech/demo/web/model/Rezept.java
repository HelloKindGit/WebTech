package htw.berlin.webtech.demo.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String beschreibung;
    private Integer vorbereitungsZeit;
    private Integer kochZeit;
    private Integer portionen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezept")
    private Set<Zutat> zutaten = new HashSet<>();

    public Rezept() {}

    public Rezept(String name) {
        this.name = name;
    }

    public Rezept(Long id, String name, String beschreibung, Integer vorbereitungsZeit, Integer kochZeit, Integer portionen) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.vorbereitungsZeit = vorbereitungsZeit;
        this.kochZeit = kochZeit;
        this.portionen = portionen;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Integer getVorbereitungsZeit() {
        return vorbereitungsZeit;
    }

    public void setVorbereitungsZeit(Integer vorbereitungsZeit) {
        this.vorbereitungsZeit = vorbereitungsZeit;
    }

    public Integer getKochZeit() {
        return kochZeit;
    }

    public void setKochZeit(Integer kochZeit) {
        this.kochZeit = kochZeit;
    }

    public Integer getPortionen() {
        return portionen;
    }

    public void setPortionen(Integer portionen) {
        this.portionen = portionen;
    }

    public Set<Zutat> getZutaten() {
        return zutaten;
    }

    public void addZutat(Zutat zutat) {
        zutat.setRezept(this);
        this.zutaten.add(zutat);
    }

    public void deleteZutat(Zutat zutat) {
        zutat.setRezept(null);
        this.zutaten.remove(zutat);
    }

    @Override
    public String toString() {
        return "Rezept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vorbereitungsZeit=" + vorbereitungsZeit +
                ", kochZeit=" + kochZeit +
                ", portionen=" + portionen +
                ", zutaten=" + zutaten +
                '}';
    }

}
