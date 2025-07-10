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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

    private final ConverterService converterService;

    public ConverterController(@Autowired ConverterService converterService){
        this.converterService = converterService;
    }

    // TODO: Add mode, where selected units don't get reset, when pressing the reset button

    @GetMapping("/")
    public String getUnitConverter(Model model){
        // TODO: Fix pre-selection of initial- and target-unit
        Converter converter = new Converter(Quantity.TEMPERATURE, TemperatureUnits.CELSIUS, TemperatureUnits.KELVIN, null, null);
        model.addAttribute("converter", converter);
        model.addAttribute("measurementUnits", getUnitsForQuantity(converter.getQuantity()));

        return "unitConverter.html";
    }

    @PostMapping("/")
    public String convertMeasuringUnits(Converter converter, Model model){
        double convertResult = converterService.convertUnits(converter);
        converter.setTargetValue(convertResult);

        model.addAttribute("measurementUnits", getUnitsForQuantity(converter.getQuantity()));
        model.addAttribute(converter);

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