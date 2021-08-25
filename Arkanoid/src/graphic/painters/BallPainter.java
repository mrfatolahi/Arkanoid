package graphic.painters;

import graphic.panels.GamePanel;
import graphic.Paintable;
import Logic.Game.Models.Ball;

import java.awt.*;

public class BallPainter implements Paintable {
    private final GamePanel gamePanel;

    public BallPainter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void paint(Graphics g) {
        for (Ball ball : gamePanel.getGame().getBalls()){
            g.setColor(ball.getColor());
            g.fillOval(ball.getBallX(), ball.getBallY(), ball.getWidth(), ball.getHeight());
        }

    }
}
