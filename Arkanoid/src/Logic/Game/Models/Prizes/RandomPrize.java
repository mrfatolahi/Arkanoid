package Logic.Game.Models.Prizes;

import Logic.Game.Models.Ball;
import Logic.Game.Models.Board;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomPrize extends Prize{
    private final Timer timer = new Timer();

    public RandomPrize(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.LIGHT_GRAY;
        this.prizeType = PrizeType.RANDOM_PRIZE;
    }

    public void activate(Board board, Ball ball) {
        Random random = new Random();
        PrizeType prizeType1 = null;
        do {
            prizeType1 = PrizeType.getPrizeTypeByPrizeNumber(random.nextInt(7) + 1);
        } while (prizeType1 == PrizeType.RANDOM_PRIZE);

        System.out.println("rand:   "+prizeType1);
        switch (prizeType1) {
            case FIERY_BALL -> new FieryBall(null).activate(ball);
            case MULTIPLE_BALLS -> new MultipeBalls(null).activate(ball);
            case BIG_BOARD -> new BigBoard(null).activate(board);
            case SMALL_BOARD -> new SmallBoard(null).activate(board);
            case FAST_BALL -> new FastBall(null).activate(ball);
            case CRAZY_BOARD -> new CrazyBoard(null).activate(board);
            case SLOW_BALL -> new SlowBall(null).activate(ball);
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                disactivate(board, ball);
            }
        }, 15000);
    }

    public void disactivate(Board board, Ball ball) {
        ball.makeNormal();
        board.makeNormal();
    }



}
