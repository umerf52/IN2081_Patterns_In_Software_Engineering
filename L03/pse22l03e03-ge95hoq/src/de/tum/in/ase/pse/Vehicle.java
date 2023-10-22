package de.tum.in.ase.pse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Vehicle {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	private String name;
	private int speed;
	private BufferedImage image;

	//TODO Implement the intrinsic attributes of the flyweight objects
	//TODO Provide a constructor with the intrinsic values

	// TODO Uncomment the following code and put it AT THE END of your constructor
	public Vehicle(String name, int speed) {
		this.name = name;
		this.speed = speed;

		try {
			File file;
			if (name.equals("Morty")) {
				file = new File("resources/Mechanical_Morty.png");
			} else {
				file = new File("resources/Rick_angry.png");
			}
			this.image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void moveCar(int currentX, int currentY, int newX, int newY);

	// TODO Set up a get method for the intrinsic values of the flyweight objects
}
