package de.tum.in.ase.pse;

public class ThermoAdapter implements ThermoInterface {

    private FahrenheitThermo thermo = new FahrenheitThermo();

    @Override
    public double getTempC() {
        double tempF = thermo.getFahrenheitTemperature();
        return (tempF - 32.0) * 5.0 / 9.0;
    }
}
