package de.tum.in.ase.pse.draw;

public class Oval extends Shape {

	public Oval(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	public void draw() {
		System.out.println("Drawing Oval: " + this.toString());
	}

	public static Oval changeForm(Shape shape) {
		return new Oval(shape.getWidth(), shape.getHeight(), shape.getX(), shape.getY());
	}

}
