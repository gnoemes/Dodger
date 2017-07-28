package objects;

import core.Handler;

import java.awt.*;

public abstract class GameObject {
     int x;
     int y;
     double xSpeed;
     double ySpeed;
    private ID id;

    public GameObject(int x, int y, ID id, Handler handler) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getXSpeed() {
        return this.xSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public abstract void tick();

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }

    public abstract Rectangle getBounds();
}
