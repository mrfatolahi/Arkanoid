package Logic.Game.Models.Bricks;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BlinkerBrick extends Brick{
    private boolean visible;
    private final Timer timer = new Timer();

    public BlinkerBrick(int x, int y) {
        super(x, y);
        this.visible = false;
        this.point = 40;
        this.strength = 1;
        this.color = Color.GREEN;
        this.brickType = BrickType.BLINKER_BRICK;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (visible){
                    visible = false;
                    color = Color.BLACK;
                }else{
                    visible = true;
                    color = color.GREEN;
                }
            }
        },0, 2000);
    }

    public boolean isVisible() {
        return visible;
    }

}
