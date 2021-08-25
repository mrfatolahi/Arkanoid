package Logic.Game.Models.Bricks;

import Logic.Game.Models.Bricks.Brick;
import Logic.Game.Models.Bricks.BrickType;
import Logic.Game.Models.Prizes.*;

import java.awt.*;
import java.util.Random;

public class PrizeBrick extends Brick {
    private final Prize prize;

    public PrizeBrick(int x, int y) {
        super(x, y);
        this.point = 45;
        this.strength = 1;
        this.color = Color.PINK;
        this.brickType = BrickType.PRIZE_BRICK;
        Random random = new Random();
        PrizeType prizeType = PrizeType.getPrizeTypeByPrizeNumber(random.nextInt(7) + 1);
        switch (prizeType) {
            case FIERY_BALL -> this.prize = new FieryBall(this);
            case MULTIPLE_BALLS -> this.prize = new MultipeBalls(this);
            case BIG_BOARD -> this.prize = new BigBoard(this);
            case SMALL_BOARD -> this.prize = new SmallBoard(this);
            case FAST_BALL -> this.prize = new FastBall(this);
            case CRAZY_BOARD -> this.prize = new CrazyBoard(this);
            case RANDOM_PRIZE -> this.prize = new RandomPrize(this);
            case SLOW_BALL -> this.prize = new SlowBall(this);
            default -> this.prize = null;
        }
    }

    public Prize getPrize() {
        return prize;
    }


}
