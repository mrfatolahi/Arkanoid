package Logic.Game.Models.Bricks;

import java.awt.*;

public class InvisibleBrick extends Brick {
    public InvisibleBrick(int x, int y) {
        super(x, y);
        this.point = 30;
        this.strength = 1;
        this.color = Color.BLACK;
        this.brickType = BrickType.INVISIBLE_BRICK;
    }
}
