package moritz.schmoetzer.UnitConverter.enums;

import moritz.schmoetzer.UnitConverter.interfaces.Unit;

public enum TemperatureUnits implements Unit {
    // Celsius is the base value
    // Metric
    CELSIUS("°C", "°C (Celsius)", 1),
    KELVIN("K", "K (Kelvin)", 1),

    // Imperial
    FAHRENHEIT("°F", "°F (Fahrenheit)", 1);

    private String abbr;
    private String text;
    private double value;

    public String getText() {
        return text;
    }

    public String getAbbr(){
        return this.abbr;
    }

    public double getValue(){
        return this.value;
    }

    private TemperatureUnits(String abbr, String text, double value){
        this.abbr = abbr;
        this.text = text;
        this.value = value;
    }
}