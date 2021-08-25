package graphic.painters;

import graphic.panels.GamePanel;
import graphic.Paintable;
import Logic.Game.Models.Prizes.Prize;

import java.awt.*;

public class PrizePainter implements Paintable {
    private final GamePanel gamePanel;

    public PrizePainter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void paint(Graphics g) {
        for (Prize prize: gamePanel.getGame().getReleasedPrizes()) {
            g.setColor(prize.getColor());
            g.fillOval(prize.getPrizeX(), prize.getPrizeY(), prize.getWIDTH(), prize.getHEIGHT());
        }
    }
}
