package moritz.schmoetzer.UnitConverter.services;

import moritz.schmoetzer.UnitConverter.models.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    public double convertUnits(Converter converter){
        double initialValue = converter.getInitialValue();
        double initialUnit = converter.getInitialUnit().getValue();
        double targetUnit = converter.getTargetUnit().getValue();

        double targetValue = Math.round((initialValue * initialUnit / targetUnit) * 100000.0) / 100000.0; // 5 decimal points

        return targetValue;
    }
}