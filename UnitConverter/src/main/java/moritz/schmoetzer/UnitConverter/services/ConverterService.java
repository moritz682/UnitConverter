package moritz.schmoetzer.UnitConverter.services;

import moritz.schmoetzer.UnitConverter.enums.Quantity;
import moritz.schmoetzer.UnitConverter.interfaces.Unit;
import moritz.schmoetzer.UnitConverter.models.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    public double convertUnits(Converter converter){
        Quantity quantity = converter.getQuantity();

        Unit initialUnit = converter.getInitialUnit();
        Unit targetUnit = converter.getTargetUnit();
        double initialValue = converter.getInitialValue();

        double targetValue;
        if (quantity.equals(Quantity.TEMPERATURE)){ // Switch between Temperature or Length/Weight conversion.
            targetValue = convertTemperature(initialUnit.getAbbr(), targetUnit.getAbbr(), initialValue);
        } else{
            targetValue = convertLengthsOrWeights(initialUnit.getValue(), targetUnit.getValue(), initialValue);
        }

        return Math.round(targetValue * 100000.0) / 100000.0; // round to 5 decimal points
    }

    // Lengths and Weights
    public double convertLengthsOrWeights(double initialUnit, double targetUnit, double initialValue){
        double targetValue = initialValue * initialUnit / targetUnit;

        return targetValue;
    }

    // Temperatures
    public double convertTemperature(String initialUnit, String targetUnit, double initialValue){
        switch (initialUnit + "->" + targetUnit){
            case "°C->°F":
                return convertCelsiusToFahrenheit(initialValue);
            case "°C->K":
                return convertCelsiusToKelvin(initialValue);
            case "°F->°C":
                return convertFahrenheitToCelsius(initialValue);
            case "°F->K":
                return convertFahrenheitToKelvin(initialValue);
            case "K->°C":
                return convertKelvinToCelsius(initialValue);
            case "K->°F":
                return convertKelvinToFahrenheit(initialValue);
            default:
                return initialValue;
        }
    }

    public double convertCelsiusToFahrenheit(double initialValue){
        double targetValue = initialValue * 1.8 + 32;

        return targetValue;
    }

    public double convertCelsiusToKelvin(double initialValue){
        double targetValue = initialValue + 273.15;

        return targetValue;
    }

    public double convertFahrenheitToCelsius(double initialValue){
        double targetValue = (initialValue - 32) * (5.0/9.0);

        return targetValue;
    }

    public double convertFahrenheitToKelvin(double initialValue){
        double targetValue = convertCelsiusToKelvin(convertFahrenheitToCelsius(initialValue)); // (°F - 32) * (5.0/9.0) + 237.15 = °K

        return targetValue;
    }

    public double convertKelvinToCelsius(double initialValue){
        double targetValue = initialValue - 273.15;

        return targetValue;
    }

    public double convertKelvinToFahrenheit(double initialValue){
        double targetValue = convertCelsiusToFahrenheit(convertKelvinToCelsius(initialValue)); // (°K - 273.15) * 1.8 + 32 = °F

        return targetValue;
    }
}