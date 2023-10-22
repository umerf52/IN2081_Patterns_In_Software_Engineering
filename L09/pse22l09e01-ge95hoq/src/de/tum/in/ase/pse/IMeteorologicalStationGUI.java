package de.tum.in.ase.pse;

/**
 * IMeteorologalStationGUI declares an interface is used to decouple the
 * concrete GUI implementation from the controller. It provides methods that the
 * controller can use to update the GUI.
 */
public interface IMeteorologicalStationGUI {

	void show();

	void displayTemperature(int temperature);

	void displayWindspeed(int windspeed);

	void displayHumidity(int humidity);
}
