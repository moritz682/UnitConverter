package moritz.schmoetzer.UnitConverter.controller;

import moritz.schmoetzer.UnitConverter.enums.Quantity;
import moritz.schmoetzer.UnitConverter.enums.LengthUnits;
import moritz.schmoetzer.UnitConverter.enums.TemperatureUnits;
import moritz.schmoetzer.UnitConverter.enums.WeightUnits;
import moritz.schmoetzer.UnitConverter.interfaces.Unit;
import moritz.schmoetzer.UnitConverter.models.Converter;
import moritz.schmoetzer.UnitConverter.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("converter")
public class ConverterController {

    private final ConverterService converterService;

    public ConverterController(@Autowired ConverterService converterService){
        this.converterService = converterService;
    }

    @GetMapping("/")
    public String getUnitConverter(@RequestParam(required = false) String quantity, Model model){
        Converter converter;

        if (!model.containsAttribute("converter")){ // If no converter was instantiated before e.g. opening the site for the first time
            converter = new Converter(Quantity.LENGTH, LengthUnits.METER, LengthUnits.KILOMETER, null, null);
            model.addAttribute(converter);
        } else{
            converter = (Converter) model.getAttribute("converter");
            if (quantity != null){
                if (!converter.getQuantity().name().toLowerCase().equals(quantity)){ // If the user is switching to a different converter --> providing a new converter with sample values
                    switch (quantity){
                        case "length":
                            converter = new Converter(Quantity.LENGTH, LengthUnits.METER, LengthUnits.KILOMETER, null, null);
                            break;
                        case "weight":
                            converter = new Converter(Quantity.WEIGHT, WeightUnits.GRAM, WeightUnits.KILOGRAM, null, null);
                            break;
                        case "temperature":
                            converter = new Converter(Quantity.TEMPERATURE, TemperatureUnits.CELSIUS, TemperatureUnits.FAHRENHEIT, null, null);
                            break;
                    }
                }
            } else{ // Getting redirected after resetting the converter --> clearing the initial- and target-value.
                converter.setInitialValue(null);
                converter.setTargetValue(null);
            }
        }

        model.addAttribute("converter", converter);
        model.addAttribute("measurementUnits", getUnitsForQuantity(converter.getQuantity()));

        return "unitConverter.html";
    }

    @PostMapping("/")
    public String convertMeasuringUnits(Converter converter, Model model){
        double convertResult = converterService.convertUnits(converter);
        converter.setTargetValue(convertResult);

        model.addAttribute("measurementUnits", getUnitsForQuantity(converter.getQuantity()));

        return "unitConverter.html";
    }

    private Unit[] getUnitsForQuantity(Quantity quantity){
        switch (quantity){
            case LENGTH:
                return LengthUnits.values();
            case WEIGHT:
                return WeightUnits.values();
            case TEMPERATURE:
                return TemperatureUnits.values();
            default:
                throw new IllegalStateException("Unexpected Unit: " + quantity);
        }
    }
}