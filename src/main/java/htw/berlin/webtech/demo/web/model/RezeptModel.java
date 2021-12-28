package htw.berlin.webtech.demo.web.model;

import java.util.HashSet;
import java.util.Set;

public class RezeptModel {
    private Long id;
    private String name;
    private String beschreibung;
    private Integer vorbereitungsZeit;
    private Integer kochZeit;
    private Integer portionen;
    private Set<ZutatModel> zutaten = new HashSet<>();

    public RezeptModel() {
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

    public Set<ZutatModel> getZutaten() {
        return zutaten;
    }

    public void setZutaten(Set<ZutatModel> zutaten) {
        this.zutaten = zutaten;
    }
}
