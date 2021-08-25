package Logic.Game.Models;

import graphic.panels.GamePanel;
import Logic.Game.Game;

import java.awt.*;


public class Board {
    private final Game game;
    private int boardX;
    private final int boardY = 550;
    private int width;
    private final int height;
    private final int speed;
    private final Color color;
    private boolean crazy;

    public Board(Game game) {
        this.game = game;
        this.boardX = 350;
        this.width = 100;
        this.height = 8;
        this.color = Color.GREEN;
        this.speed = 20;
        this.crazy = false;
    }

    public void moveRight(){
        if(!game.isStarted() || game.isPaused()){return;}
        if (!(boardX + width >= GamePanel.getWIDTH() - 10) && !crazy){
            this.boardX += speed;
        }else
        if (!(boardX <= 10) && crazy){
            this.boardX -= speed;
        }
    }

    public void moveLeft(){
        if(!game.isStarted() || game.isPaused()){return;}
        if (!(boardX <= 10) && !crazy){
            this.boardX -= speed;
        }else
        if (!(boardX + width >= GamePanel.getWIDTH() - 10) && crazy){
            this.boardX += speed;
        }
    }

    public int getBoardX() {
        return boardX;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getBoardY() {
        return boardY;
    }

    public void makeNormal(){
        this.width = 100;
        this.crazy = false;
    }

    public void makeBig(){
        this.width *= 2;
    }

    public void makeSmall(){
        this.width /= 2;
    }

    public void makeCrazy(){
        this.crazy = true;
    }

    public boolean isCrazy() {
        return crazy;
    }

    public void setBoardX(int boardX) {
        this.boardX = boardX;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setCrazy(boolean crazy) {
        this.crazy = crazy;
    }

    public Rectangle getRectangle(){
        return new Rectangle(boardX, boardY, width, height);
    }

    public Rectangle getRightEdgeRectangle(){
        return new Rectangle(boardX+width-5, boardY, 5, height);
    }

    public Rectangle getLeftEdgeRectangle(){
        return new Rectangle(boardX, boardY, 5, height);
    }


}
