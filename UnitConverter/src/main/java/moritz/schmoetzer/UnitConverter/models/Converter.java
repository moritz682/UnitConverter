package moritz.schmoetzer.UnitConverter.models;

import moritz.schmoetzer.UnitConverter.enums.Units;

public class Converter {
    private Units initialUnit;
    private Units targetUnit;
    private Double initialValue;
    private Double targetValue;

    public Converter(Units initialUnit, Units targetUnit, Double initialValue, Double targetValue) {
        this.initialUnit = initialUnit;
        this.targetUnit = targetUnit;
        this.initialValue = initialValue;
        this.targetValue = targetValue;
    }

    public Units getInitialUnit() {
        return initialUnit;
    }

    public void setInitialUnit(Units initialUnit) {
        this.initialUnit = initialUnit;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Units getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(Units targetUnit) {
        this.targetUnit = targetUnit;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Double targetValue) {
        this.targetValue = targetValue;
    }
}