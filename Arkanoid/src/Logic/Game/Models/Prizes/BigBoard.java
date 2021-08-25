package Logic.Game.Models.Prizes;

import Logic.Game.Models.Board;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BigBoard extends Prize{
    private final Timer timer = new Timer();


    public BigBoard(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.BLUE;
        this.prizeType = PrizeType.BIG_BOARD;
    }

    public void activate(Board board) {
        board.makeBig();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                disactivate(board);
            }
        }, 10000);
    }

    public void disactivate(Board board) {
        board.makeNormal();
    }
}
