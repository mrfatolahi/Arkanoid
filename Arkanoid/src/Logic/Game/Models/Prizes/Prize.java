package Logic.Game.Models.Prizes;

import Logic.Game.Game;
import Logic.Game.Models.Ball;
import Logic.Game.Models.Board;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;

public class Prize{
    protected PrizeType prizeType;
    private int prizeX;
    private int prizeY;
    private final int SPEED;
    private final int WIDTH;
    private final int HEIGHT;
    protected Color color;
    private boolean used;

    public Prize(PrizeBrick prizeBrick) {
        try {
            this.prizeX = prizeBrick.getX();
        }catch (Exception ignored){
            this.prizeX = 0;
        }

        try {
            this.prizeY = prizeBrick.getY();
        }catch (Exception ignored){
            this.prizeY = 0;
        }

        this.WIDTH = 10;
        this.HEIGHT = 20;
        this.SPEED = 1;
    }

    public final int getPrizeX() {
        return prizeX;
    }

    public final int getPrizeY() {
        return prizeY;
    }

    public final int getWIDTH() {
        return WIDTH;
    }

    public final int getHEIGHT() {
        return HEIGHT;
    }

    public final Color getColor() {
        return color;
    }

    protected void activate(Board board, Ball ball) {

    }

    protected void disactivate(Board board, Ball ball) {

    }

    protected void activate(Ball ball) {

    }

    protected void disactivate(Ball ball) {

    }

    protected void activate(Board board) {

    }

    protected void disactivate(Board board) {

    }

    protected void activate(Game game) {

    }

    protected void disactivate(Game game) {

    }

    public PrizeType getPrizeType() {
        return prizeType;
    }

    public final void move(Game game){
        if(!game.isStarted() || game.isPaused()){return;}
        this.prizeY += SPEED;

        Rectangle prizeRectangle = new Rectangle(prizeX, prizeY, WIDTH, HEIGHT);
        Rectangle boardRect = new Rectangle(game.getBoard().getBoardX(), 550,
                game.getBoard().getWidth(), game.getBoard().getHeight());

        if(prizeRectangle.intersects(boardRect) && !this.used){

            game.getBalls().get(0).makeNormal();
            game.getBoard().makeNormal();

            this.used = true;
            this.prizeY = 1000;
            System.out.println(prizeType);
            switch (this.getPrizeType()) {
                case FIERY_BALL -> this.activateAsFieryBall((FieryBall) this, game.getMainBall());
                case MULTIPLE_BALLS -> this.activateAsMultipleBalls((MultipeBalls) this, game);
                case BIG_BOARD -> this.activateAsBigBoard((BigBoard) this, game.getBoard());
                case SMALL_BOARD -> this.activateAsSmallBoard((SmallBoard) this, game.getBoard());
                case FAST_BALL -> this.activateAsFastBall((FastBall) this, game.getMainBall());
                case CRAZY_BOARD -> this.activateAsCrazyBoard((CrazyBoard) this, game.getBoard());
                case SLOW_BALL -> this.activateAsSlowBall((SlowBall) this, game.getMainBall());
                case RANDOM_PRIZE -> this.activateAsRandomPrize((RandomPrize) this, game.getBoard(), game.getMainBall());
            }
        }
    }

    private void activateAsBigBoard(BigBoard bigBoard, Board board){
        bigBoard.activate(board);
    }

    private void activateAsFieryBall(FieryBall fieryBall, Ball ball){
        fieryBall.activate(ball);
    }

    private void activateAsMultipleBalls(MultipeBalls multipeBalls, Game game){
        multipeBalls.activate(game);
    }

    private void activateAsSmallBoard(SmallBoard smallBoard, Board board){
        smallBoard.activate(board);
    }

    private void activateAsFastBall(FastBall fastBall, Ball ball){
        fastBall.activate(ball);
    }

    private void activateAsCrazyBoard(CrazyBoard crazyBoard, Board board){
        crazyBoard.activate(board);
    }

    private void activateAsSlowBall(SlowBall slowBall, Ball ball){
        slowBall.activate(ball);
    }

    private void activateAsRandomPrize(RandomPrize randomPrize, Board board, Ball ball){
        randomPrize.activate(board, ball);
    }

    public void setPrizeX(int prizeX) {
        this.prizeX = prizeX;
    }

    public void setPrizeY(int prizeY) {
        this.prizeY = prizeY;
    }
}
