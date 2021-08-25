package Logic.Game.MapGenerator;

import Logic.Game.Game;
import Logic.Game.Models.Bricks.*;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class MapGenerator implements ActionListener {
    private LinkedList<LinkedList<Brick>> rows;
    private int brickX;
    private int brickY;
    private final Game game;
    private final Timer newRowTimer;

    public MapGenerator(Game game) {
        this.game = game;
        this.brickX = 50;
        this.brickY = 40;
        this.rows = new LinkedList<LinkedList<Brick>>();
        this.newRowTimer = new Timer();

        for (int i = 0; i < 3; i++) {
            MapRow rowMap = new MapRow();
            LinkedList<Brick> row = new LinkedList<>();
            for (BrickType BrickType : rowMap) {
                switch (BrickType){
                    case GLASSY_BRICK -> row.add(new GlassyBrick(brickX, brickY));
                    case WOODEN_BRICK -> row.add(new WoodenBrick(brickX, brickY));
                    case INVISIBLE_BRICK -> row.add(new InvisibleBrick(brickX, brickY));
                    case BLINKER_BRICK -> row.add(new BlinkerBrick(brickX, brickY));
                    case PRIZE_BRICK -> row.add(new PrizeBrick(brickX, brickY));
                }
                brickX += Brick.getWIDTH() + 10;
            }
            rows.add(row);
            brickY += Brick.getHIEGHT() + 10;
            brickX = 50;
        }

        newRowTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                addNewRow();
            }
        }, 0, 30000);
    }

    public void addNewRow(){
        if (game.isPaused()){return;}
        for (LinkedList<Brick> row : rows){
            for (Brick brick : row){
                brick.setY(brick.getY() + Brick.getHIEGHT() + 10);
            }
        }
        brickY = 40;
        MapRow rowMap = new MapRow();
        LinkedList<Brick> row = new LinkedList<>();
        for (BrickType BrickType : rowMap) {
            switch (BrickType){
                case GLASSY_BRICK -> row.add(new GlassyBrick(brickX, brickY));
                case WOODEN_BRICK -> row.add(new WoodenBrick(brickX, brickY));
                case INVISIBLE_BRICK -> row.add(new InvisibleBrick(brickX, brickY));
                case BLINKER_BRICK -> row.add(new BlinkerBrick(brickX, brickY));
                case PRIZE_BRICK -> row.add(new PrizeBrick(brickX, brickY));
            }
            brickX += Brick.getWIDTH() + 10;
        }
        rows.add(row);
        brickY += Brick.getHIEGHT() + 10;
        brickX = 50;
    }

    public boolean checkForEndGame(){

        if (rows.size() >= 8){
            for (Brick brick : rows.get(rows.size()-7)){
                if (!brick.isDestroyed()){
                    return true;
                }
            }
            return false;
        }

        for (LinkedList<Brick> row : rows){
            for (Brick brick : row){
                if (!brick.isDestroyed()){
                    return false;
                }
            }
        }
        return true;
    }


    public LinkedList<LinkedList<Logic.Game.Models.Bricks.Brick>> getRows() {
        return rows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setRows(LinkedList<LinkedList<Brick>> rows) {
        this.rows = rows;
    }
}
