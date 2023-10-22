package de.tum.in.ase.pse.draw;

import java.util.UUID;

public abstract class Shape {
    private final UUID id;
    private final int width;
    private final int height;
    private final int x;
    private final int y;

    public Shape(int width, int height, int x, int y) {
        id = UUID.randomUUID();
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public UUID getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void draw();

    @Override
    public String toString() {
        return getClass()
                .getSimpleName() + " [width=" + width + ", height=" + height + ", x=" + x + ", y=" + y + ", id=" + id + "]";
    }
}
