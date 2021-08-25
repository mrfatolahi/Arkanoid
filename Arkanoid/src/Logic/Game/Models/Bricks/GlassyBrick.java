package Logic.Game.Models.Bricks;

import java.awt.*;

public class GlassyBrick extends Brick{
    public GlassyBrick(int x, int y) {
        super(x, y);
        this.point = 20;
        this.strength = 1;
        this.color = Color.CYAN;
        this.brickType = BrickType.GLASSY_BRICK;
    }
}
