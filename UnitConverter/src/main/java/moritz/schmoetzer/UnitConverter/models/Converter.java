package moritz.schmoetzer.UnitConverter.models;

import moritz.schmoetzer.UnitConverter.enums.Quantity;
import moritz.schmoetzer.UnitConverter.interfaces.Unit;

public class Converter {
    private Quantity quantity;
    private Unit initialUnit;
    private Unit targetUnit;
    private Double initialValue;
    private Double targetValue;

    public Converter(Quantity quantity, Unit initialUnit, Unit targetUnit, Double initialValue, Double targetValue) {
        this.quantity = quantity;
        this.initialUnit = initialUnit;
        this.targetUnit = targetUnit;
        this.initialValue = initialValue;
        this.targetValue = targetValue;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Unit getInitialUnit() {
        return initialUnit;
    }

    public void setInitialUnit(Unit initialUnit) {
        this.initialUnit = initialUnit;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Unit getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(Unit targetUnit) {
        this.targetUnit = targetUnit;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Double targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public String toString() {
        return "Converter{" +
                "quantity=" + quantity +
                ", initialUnit=" + initialUnit +
                ", targetUnit=" + targetUnit +
                ", initialValue=" + initialValue +
                ", targetValue=" + targetValue +
                '}';
    }
}