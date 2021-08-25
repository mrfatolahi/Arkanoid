package Logic.Game.Models.Bricks;

import Logic.Game.Game;
import Logic.Game.Models.Ball;

import java.awt.*;

public abstract class Brick {
    private final int X;
    private int Y;
    private static final int WIDTH = 90;
    private static final int HIEGHT = 50;
    protected BrickType brickType;
    protected int point;
    protected int strength;
    protected Color color;
    private boolean destroyed;

    public Brick(int x, int y) {
        this.X = x;
        this.Y = y;
        this.destroyed = false;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getPoint() {
        return point;
    }

    public int getStrength() {
        return strength;
    }

    public Color getColor() {
        return color;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHIEGHT() {
        return HIEGHT;
    }

    /**
     * hit the brick
     * return false if brick doesn't destroy
     * return true if brick destroy
     */
    public boolean hit(Ball ball){
        if (ball.isFiery()){
            return true;
        }
        this.strength--;
        return this.strength == 0;
    }

    public void destroy(){
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setY(int y) {
        Y = y;
    }

    public BrickType getBrickType() {
        return brickType;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Rectangle getRectangle(){
        return new Rectangle(X, Y, WIDTH, HIEGHT);
    }
}
