package htw.berlin.webtech.demo.web.model;

import java.math.BigDecimal;

public class ZutatModel {
    private Long id;
    private Long recipeId;
    private String name;
    private BigDecimal menge;

    public ZutatModel() {
    }

    public ZutatModel(Long id, Long recipeId, String name, BigDecimal menge) {
        this.id = id;
        this.recipeId = recipeId;
        this.name = name;
        this.menge = menge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
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

    @Override
    public String toString() {
        return "ZutatModel{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", name='" + name + '\'' +
                ", menge=" + menge +
                '}';
    }
}
