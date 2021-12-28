package htw.berlin.webtech.demo.web.model;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by max on 2019-05-04
 */
@Component
public class RezeptZuRezeptModel implements Converter<Rezept, RezeptModel> {

    private final ZutatToZutatModel zutatenConverter;

    public RezeptZuRezeptModel(ZutatToZutatModel zutatenConverter) {
        this.zutatenConverter = zutatenConverter;
    }

    @Synchronized
    @Nullable
    public RezeptModel convert(Rezept rezept) {

        final RezeptModel rezeptModel = new RezeptModel();
        rezeptModel.setId(rezept.getId());
        rezeptModel.setName(rezept.getName());
        rezeptModel.setBeschreibung(rezept.getBeschreibung());
        rezeptModel.setVorbereitungsZeit(rezept.getVorbereitungsZeit());
        rezeptModel.setKochZeit(rezept.getKochZeit());
        rezeptModel.setPortionen(rezept.getPortionen());

        if (rezept.getZutaten() != null && rezept.getZutaten().size() > 0) {
            rezept.getZutaten()
                    .forEach(zutat -> rezeptModel.getZutaten().add(zutatenConverter.convert(zutat)));
        }

        return rezeptModel;
    }
}
