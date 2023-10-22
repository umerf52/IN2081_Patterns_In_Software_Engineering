package de.tum.in.ase.pse.draw;

public class Square extends Shape {
    public Square(int width, int x, int y) {
        super(width, width, x, y);
    }

    public static Square changeForm(Shape shape) {
        return new Square(shape.getWidth(), shape.getX(), shape.getY());
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square: " + this);
    }
}

