package Logic.Game.Models.Prizes;

import Logic.Game.Models.Ball;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class FieryBall extends Prize{
    private final Timer timer = new Timer();

    public FieryBall(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.RED;
        this.prizeType = PrizeType.FIERY_BALL;
    }

    public void activate(Ball ball) {
        ball.makeFiery();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               disactivate(ball);
            }
        }, 10000);
    }

    public void disactivate(Ball ball) {
        ball.makeNormal();
    }


}
