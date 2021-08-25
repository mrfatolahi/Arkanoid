package graphic.painters;

import graphic.panels.GamePanel;
import graphic.Paintable;

import java.awt.*;

public class BoardPainter implements Paintable {
    private final GamePanel gamePanel;

    public BoardPainter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(gamePanel.getGame().getBoard().getColor());
        g.fillRect(gamePanel.getGame().getBoard().getBoardX(), gamePanel.getGame().getBoard().getBoardY(),
                gamePanel.getGame().getBoard().getWidth(), gamePanel.getGame().getBoard().getHeight());
    }
}
