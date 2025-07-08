package moritz.schmoetzer.UnitConverter.controller;

import moritz.schmoetzer.UnitConverter.enums.Units;
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

    @GetMapping("/")
    public String getUnitConverter(Model model){
        model.addAttribute("measurementUnits", Units.values());
        model.addAttribute("converter", new Converter(Units.KILOMETER, Units.KILOMETER, null, null));

        return "unitConverter.html";
    }

    @PostMapping("/")
    public String convertMeasuringUnits(Converter converter, Model model){
        double convertResult = converterService.convertUnits(converter);
        converter.setTargetValue(convertResult);

        model.addAttribute("measurementUnits", Units.values());
        model.addAttribute(converter);

        return "unitConverter.html";
    }
}