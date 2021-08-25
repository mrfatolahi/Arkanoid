package Logic.Game.Models.Prizes;

import Logic.Game.Models.Board;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CrazyBoard  extends Prize{
    private final Timer timer = new Timer();

    public CrazyBoard(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.PINK;
        this.prizeType = PrizeType.CRAZY_BOARD;
    }

    public void activate(Board board) {
        board.makeCrazy();
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
