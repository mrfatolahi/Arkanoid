package Logic.Game;

import Logic.Game.MapGenerator.MapGenerator;
import Logic.Game.Models.Ball;
import Logic.Game.Models.Board;
import Logic.Game.Models.Prizes.Prize;

import java.io.File;
import java.util.LinkedList;

public class Game {
    private String name;
    private int ID;
    private int lifes_left;
    private LinkedList<Ball> balls;
    private final MapGenerator mapGenerator;
    private final Board board;
    private int player_score;
    private LinkedList<Prize> releasedPrizes;
    private boolean started;
    private boolean finished;
    private boolean paused;

    public Game() {
        String name = "";
        File file = new File("Database/Games");
        this.ID = file.listFiles().length + 1;
        this.lifes_left = 3;
        this.balls = new LinkedList<>();
        this.balls.add(new Ball(this));
        this.board = new Board(this);
        this.mapGenerator = new MapGenerator(this);
        this.player_score = 0;
        this.releasedPrizes = new LinkedList<Prize>();
        this.started = false;
        this.finished = false;
        this.paused = true;
    }

    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }

    public int getLifes_left() {
        return lifes_left;
    }

    public LinkedList<Ball> getBalls() {
        return balls;
    }

    public Ball getMainBall() {
        return balls.get(0);
    }

    public Board getBoard() {
        return board;
    }

    public int getPlayer_score() {
        return player_score;
    }

    public void setLifes_left(int lifes_left) {
        this.lifes_left = lifes_left;
    }

    public void setPlayer_score(int player_score) {
        this.player_score = player_score;
    }

    public void addPoint(int pointToAdd){
        this.player_score += pointToAdd;
    }

    public LinkedList<Prize> getReleasedPrizes() {
        return releasedPrizes;
    }

    public void addReleasedPrize(Prize prize){
        this.releasedPrizes.add(prize);
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getID() {
        return ID;
    }

    public void setBalls(LinkedList<Ball> balls) {
        this.balls = balls;
    }

    public void setReleasedPrizes(LinkedList<Prize> releasedPrizes) {
        this.releasedPrizes = releasedPrizes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void checkForEndGame(){
        for (int i = 0; i < balls.size(); i++) {
            if(balls.get(i).getBallY() > 600){
                balls.remove(i);
                i = 0;
            }
        }

        if(balls.size() == 0){
            this.lifes_left--;
            if (lifes_left != 0){
                this.balls.add(new Ball(this));
            }
        }

        if(lifes_left == 0){
            this.finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
