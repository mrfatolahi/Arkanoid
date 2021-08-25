package Logic.Game.Models.Prizes;

import Logic.Game.Models.Ball;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SlowBall extends Prize{
    private final Timer timer = new Timer();

    public SlowBall(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.YELLOW;
        this.prizeType = PrizeType.SLOW_BALL;
    }

    public void activate(Ball ball) {
        ball.makeSlow();
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
