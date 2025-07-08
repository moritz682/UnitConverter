package moritz.schmoetzer.UnitConverter.enums;

public enum Units {
    // Meter is the base value
    // Metric
    KILOMETER("km", "km (kilometer)", 1000),
    METER("m", "m (meter)", 1),
    CENTIMETER("cm", "cm (centimeter)", 0.01),
    MILLIMETER("mm", "mm (millimeter)", 0.001),

    // Imperial
    MILE("mi", "mi (mile)", 1609.34),
    YARD("yd", "yd (yard)", 0.9144),
    FOOT("ft", "ft (foot)", 0.3048),
    INCH("in", "in (inch)", 0.0254);

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

    private Units(String abbr, String text, double value){
        this.abbr = abbr;
        this.text = text;
        this.value = value;
    }
}