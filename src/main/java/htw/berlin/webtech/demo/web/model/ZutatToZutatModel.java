package htw.berlin.webtech.demo.web.model;

import lombok.Synchronized;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

@Component
public class ZutatToZutatModel implements Converter<Zutat, ZutatModel> {

    @Synchronized
    @Nullable
    public ZutatModel convert(Zutat zutat) {

        ZutatModel zutatModel = new ZutatModel();
        zutatModel.setId(zutat.getId());
        if (zutat.getRezept() != null) {
            zutatModel.setRecipeId(zutat.getRezept().getId());
        }
        zutatModel.setName(zutat.getName());
        zutatModel.setMenge(zutat.getMenge());
        return zutatModel;
    }
}
