package Logic.Game.Models.Prizes;

import Logic.Game.Models.Board;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SmallBoard extends Prize{
    private final Timer timer = new Timer();

    public SmallBoard(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.CYAN;
        this.prizeType = PrizeType.SMALL_BOARD;
    }

    public void activate(Board board) {
        board.makeSmall();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                disactivate(board);
            }
        }, 30000);
    }

    public void disactivate(Board board) {
        board.makeNormal();
    }
}
