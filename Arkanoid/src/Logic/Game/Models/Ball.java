package Logic.Game.Models;

import graphic.panels.GamePanel;
import Logic.Game.Game;
import Logic.Game.Models.Bricks.BlinkerBrick;
import Logic.Game.Models.Bricks.BrickType;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Random;

public class Ball {
    private final Game game;
    private int ballX;
    private int ballY;
    private int velocityX;
    private int velocityY;
    private int width;
    private int height;
    private Color color;
    private boolean fiery;

    public Ball(Game game) {
        this.game = game;
        this.ballX = 400;
        this.ballY = 530;
        Random random = new Random();
        int a = random.nextInt(2)+1;
        switch (a) {
            case 1 -> {
                this.velocityX = -4;
                this.velocityY = 2;
            }
            case 2 -> {
                this.velocityX = 4;
                this.velocityY = -2;
            }
            case 3 -> {
                this.velocityX = -4;
                this.velocityY = -2;
            }
        }
        this.width = 20;
        this.height = 20;
        this.color = Color.white;
        this.fiery = false;
    }

    public void move(){
        if(game.isPaused()){return;}
        this.ballX += velocityX;
        this.ballY += velocityY;

        ckeckCollisionWithBounds();

        ckeckCollisionWithBoard();

        ckeckCollisionWithBricks();

    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void ckeckCollisionWithBounds(){
        if(ballX >= GamePanel.getWIDTH() - 10-width){
            velocityX = -1 * velocityX;
        }else
        if(ballX <= 10){
            velocityX = -1 * velocityX;
        }

        if(ballY <= 10){
            velocityY = -1 * velocityY;
        }
    }

    private void ckeckCollisionWithBoard(){
        Rectangle ballRect = new Rectangle(ballX, ballY, width, height);

        if (ballRect.intersects(this.game.getBoard().getRectangle())){
            velocityY = -1 * velocityY;
        }

        if (ballRect.intersects(this.game.getBoard().getLeftEdgeRectangle())
                || ballRect.intersects(this.game.getBoard().getRightEdgeRectangle())){
            velocityX = -1 * velocityX;
        }
    }

    private void ckeckCollisionWithBricks(){
        Rectangle ballRect = new Rectangle(ballX, ballY, width, height);
        for (int i = 0 ; i < this.game.getMapGenerator().getRows().size() ; i++){
            for (int j = 0 ; j < this.game.getMapGenerator().getRows().get(i).size() ; j++){

                if (ballRect.intersects(this.game.getMapGenerator().getRows().get(i).get(j).getRectangle()) &&
                        !this.game.getMapGenerator().getRows().get(i).get(j).isDestroyed()){

                    if (this.game.getMapGenerator().getRows().get(i).get(j).getBrickType() == BrickType.BLINKER_BRICK){
                        if (!((BlinkerBrick) this.game.getMapGenerator().getRows().get(i).get(j)).isVisible()){
                            continue;
                        }
                    }

                    this.game.addPoint(this.game.getMapGenerator().getRows().get(i).get(j).getPoint());

                    if(this.game.getMapGenerator().getRows().get(i).get(j).hit(this)){
                        this.game.getMapGenerator().getRows().get(i).get(j).destroy();

                        if(this.game.getMapGenerator().getRows().get(i).get(j).getBrickType() == BrickType.PRIZE_BRICK){
                            this.game.addReleasedPrize(((PrizeBrick) this.game.getMapGenerator().getRows().get(i).get(j)).getPrize());
                        }

                    }
                    if (!this.isFiery()){
                        velocityY = -1 * velocityY;
                    }

                }
            }
        }
    }


    public void makeFiery(){
        this.color = Color.RED;
        this.fiery = true;
    }

    public void makeFast(){
        this.velocityX *= 2;
        this.velocityY *= 2;
    }

    public void makeSlow(){
        this.velocityX /= 2;
        this.velocityY /= 2;
    }

    public void makeNormal(){
        this.color = Color.WHITE;
        this.fiery = false;
        this.width = 20;
        this.height = 20;
        if ((velocityX == 8 || velocityX == -8) && (velocityY == 4 || velocityY == -4)){
            this.velocityX /= 2;
            this.velocityY /= 2;
        }else
        if ((velocityX == 2 || velocityX == -2) && (velocityY == 1 || velocityY == -1)){
            this.velocityX *= 2;
            this.velocityY *= 2;
        }

    }

    public Color getColor() {
        return color;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public boolean isFiery() {
        return fiery;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFiery(boolean fiery) {
        this.fiery = fiery;
    }
}
