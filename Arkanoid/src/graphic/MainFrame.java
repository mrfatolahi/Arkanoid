package graphic;

import Logic.Manager;
import graphic.panels.GamePanel;
import graphic.panels.HighScoresPanel;
import graphic.panels.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final Manager manager;
    private GamePanel gamePanel;
    private final MenuPanel menuPanel;
    private final HighScoresPanel highScoresPanel;

    public MainFrame(Manager manager) throws HeadlessException {
        this.manager = manager;
        this.setTitle("Arkanoid");
        this.setVisible(true);
        this.setBackground(Color.MAGENTA);
        ImageIcon imageIcon = new ImageIcon("480px-Eo_circle_brown_letter-a.svg.png");
        this.setIconImage(imageIcon.getImage());
        this.setResizable(false);

        this.setSize(950, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.menuPanel = new MenuPanel(this);
        this.add(menuPanel);

        this.gamePanel = new GamePanel(this);
        this.addKeyListener(gamePanel);
        this.add(gamePanel);

        this.highScoresPanel = new HighScoresPanel(this);
        this.add(highScoresPanel);

        this.repaint();
        this.revalidate();
        menuPanel.repaint();
        menuPanel.revalidate();
        highScoresPanel.repaint();
        highScoresPanel.revalidate();
    }

    public Manager getManager() {
        return manager;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        System.out.println(gamePanel.getGame());
    }
}
