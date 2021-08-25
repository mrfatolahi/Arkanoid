package Logic.Game.Models.Prizes;

import Logic.Game.Models.Ball;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class FastBall extends Prize{
    private final Timer timer = new Timer();

    public FastBall(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.MAGENTA;
        this.prizeType = PrizeType.FAST_BALL;
    }

    public void activate(Ball ball) {
        ball.makeFast();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                disactivate(ball);
            }
        }, 5000);
    }

    public void disactivate(Ball ball) {
        ball.makeNormal();
    }
}
