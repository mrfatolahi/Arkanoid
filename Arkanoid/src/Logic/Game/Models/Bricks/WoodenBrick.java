package Logic.Game.Models.Bricks;

import java.awt.*;

public class WoodenBrick extends Brick {
    public WoodenBrick(int x, int y) {
        super(x, y);
        this.point = 40;
        this.strength = 2;
        this.color = new Color(181,101 ,29 );
        this.brickType = BrickType.WOODEN_BRICK;
    }
}
