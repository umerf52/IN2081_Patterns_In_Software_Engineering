package de.tum.in.ase.pse;

import java.awt.*;

public class KelvinGUI extends TemperatureGUI  {

    public KelvinGUI(TemperatureModel model, Point location) {
        super("Kelvin Temperature", model, location);
        addRaiseTempListener(() -> getModel().increaseC(1.0));
        addLowerTempListener(() -> getModel().increaseC(-1.0));
        addDisplayListener(() -> {
            double value = getDisplay();
            getModel().setK(value);
        });
    }

    @Override
    public void onUpdate(Double newState) {
        double k = TemperatureConverter.convertCelsiusToKelvin(newState);
        setDisplay(Double.toString(k));
    }
}
