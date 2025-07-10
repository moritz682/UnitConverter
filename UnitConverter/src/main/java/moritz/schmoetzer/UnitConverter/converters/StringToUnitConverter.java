package moritz.schmoetzer.UnitConverter.converters;

import moritz.schmoetzer.UnitConverter.enums.LengthUnits;
import moritz.schmoetzer.UnitConverter.enums.TemperatureUnits;
import moritz.schmoetzer.UnitConverter.enums.WeightUnits;
import moritz.schmoetzer.UnitConverter.interfaces.Unit;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToUnitConverter implements Converter<String, Unit> {

    @Override
    public Unit convert(String source) {
        for (LengthUnits lu : LengthUnits.values()){
            if (lu.getAbbr().equals(source)){
                return lu;
            }
        }
        for (WeightUnits wu : WeightUnits.values()){
            if (wu.getAbbr().equals(source)){
                return wu;
            }
        }
        for (TemperatureUnits tu : TemperatureUnits.values()){
            if (tu.getAbbr().equals(source)){
                return tu;
            }
        }
        throw new IllegalArgumentException("Unknown unit: " + source);
    }
}