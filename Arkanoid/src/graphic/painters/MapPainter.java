package graphic.painters;

import graphic.panels.GamePanel;
import graphic.Paintable;
import Logic.Game.Models.Bricks.Brick;

import java.awt.*;
import java.util.LinkedList;

public class MapPainter implements Paintable {
    private final GamePanel gamePanel;

    public MapPainter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void paint(Graphics g) {
        for (LinkedList<Brick> row : gamePanel.getGame().getMapGenerator().getRows()){
            for (Brick brick : row){
                if(!brick.isDestroyed()){
                    g.setColor(brick.getColor());
                    g.fill3DRect(brick.getX(), brick.getY(), brick.getWIDTH(), brick.getHIEGHT(), true);
                }
            }
        }
        if (gamePanel.getGame().getMapGenerator().checkForEndGame()){
            this.gamePanel.getGame().setFinished(true);
        }
    }

}
