package graphic.panels;

import graphic.MainFrame;
import graphic.savedGamesFrame.SavedGamesFrame;
import Logic.Loaders.GameLoader;
import Logic.Savers.GameSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuPanel extends JPanel implements ActionListener, MouseListener {
    private final MainFrame mainFrame;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 300;
    private final JButton newGameButtun;
    private final JButton saveGameButtun;
    private final JButton loadGameButton;
    private final JButton pauseButton;
    private final JButton exitButton;

    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(800, 0, WIDTH, HEIGHT);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.addMouseListener(this);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        this.newGameButtun = new JButton("New Game");
        this.newGameButtun.setFocusable(false);
        this.newGameButtun.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.newGameButtun.setMaximumSize(new Dimension(100, 40));
        this.add(newGameButtun);
        newGameButtun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getManager().startNewGame();
            }
        });

        this.add(Box.createRigidArea(new Dimension(0,10)));

        this.saveGameButtun = new JButton("Save Game");
        this.saveGameButtun.setFocusable(false);
        this.saveGameButtun.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.saveGameButtun.setMaximumSize(new Dimension(100, 40));
        this.add(saveGameButtun);
        saveGameButtun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainFrame.getManager().getGame().setPaused(true);
                    String name = JOptionPane.showInputDialog("Enter Name: ");
                    GameSaver.saveGame(mainFrame.getManager().getGame(), name);
                    System.exit(0);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        this.add(Box.createRigidArea(new Dimension(0,10)));

        this.loadGameButton = new JButton("Load Game");
        this.loadGameButton.setFocusable(false);
        this.loadGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.loadGameButton.setMaximumSize(new Dimension(100, 40));
        this.add(loadGameButton);
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SavedGamesFrame(mainFrame.getManager().getMainFrame(), GameLoader.loadSavedGames());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

        this.add(Box.createRigidArea(new Dimension(0,10)));

        this.pauseButton = new JButton("Play/Pause");
        this.pauseButton.setFocusable(false);
        this.pauseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.pauseButton.setMaximumSize(new Dimension(100, 40));
        this.add(pauseButton);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mainFrame.getManager().getGame().isPaused()){
                    mainFrame.getManager().getGame().setPaused(true);
                }else{
                    mainFrame.getManager().getGame().setPaused(false);
                }
            }
        });

        this.add(Box.createRigidArea(new Dimension(0,10)));

        this.exitButton = new JButton("Exit");
        this.exitButton.setFocusable(false);
        this.exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.exitButton.setMaximumSize(new Dimension(100, 40));
        this.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
