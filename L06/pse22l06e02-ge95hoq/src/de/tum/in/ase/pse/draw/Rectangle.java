package de.tum.in.ase.pse.draw;

public class Rectangle extends Shape {

	public Rectangle(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	public void draw() {
		System.out.println("Drawing Rectangle: " + this);
	}

	public static Rectangle changeForm(Shape shape) {
		return new Rectangle(shape.getWidth(), shape.getHeight(), shape.getX(), shape.getY());
	}
}
