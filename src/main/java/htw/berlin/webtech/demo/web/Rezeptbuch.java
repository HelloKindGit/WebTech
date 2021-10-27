package htw.berlin.webtech.demo.web;

import java.util.List;

public class Rezeptbuch {
    private String name;

    public Rezeptbuch(String name) {
        this.name = name;
    }

    public Rezeptbuch() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rezeptbuch{" +
                "name='" + name + '\'' +
                '}';
    }
}
