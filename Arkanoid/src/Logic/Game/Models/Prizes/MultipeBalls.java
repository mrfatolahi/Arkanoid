package Logic.Game.Models.Prizes;

import Logic.Game.Game;
import Logic.Game.Models.Ball;
import Logic.Game.Models.Bricks.PrizeBrick;

import java.awt.*;

public class MultipeBalls extends Prize{
    public MultipeBalls(PrizeBrick prizeBrick) {
        super(prizeBrick);
        this.color = Color.GREEN;
        this.prizeType = PrizeType.MULTIPLE_BALLS;
    }

    @Override
    protected void activate(Game game) {
        for (int i = 0; i < 2; i++) {
            game.getBalls().add(new Ball(game));
        }
    }

    @Override
    protected void disactivate(Game game) {
        for (int i = 0; i < game.getBalls().size() - 1; i++) {
            game.getBalls().removeLast();
        }
    }
}
