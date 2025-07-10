package moritz.schmoetzer.UnitConverter.enums;

import moritz.schmoetzer.UnitConverter.interfaces.Unit;

public enum WeightUnits implements Unit {
    // Gram is the base value
    // Metric
    TON("t", "t (ton)", 1000000),
    KILOGRAM("kg", "kg (kilogram)", 1000),
    GRAM("g", "g (gram)", 1),
    MILLIGRAM("mg", "mg (milligram)", 0.001),

    // Imperial
    POUND("lb", "lb (pound)", 453.592),
    OUNCE("oz", "oz (ounce)", 28.35);

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

    private WeightUnits(String abbr, String text, double value){
        this.abbr = abbr;
        this.text = text;
        this.value = value;
    }
}