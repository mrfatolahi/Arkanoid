package graphic.savedGamesFrame;

import graphic.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SavedGamesFrame extends JFrame {
    private final MainFrame mainFrame;

    public SavedGamesFrame(MainFrame mainFrame, LinkedList<LinkedList<String>> savedGames){
        this.mainFrame = mainFrame;
        this.setTitle("Saved Games");
        this.setVisible(true);
        this.setBackground(Color.ORANGE);
        this.revalidate();
        this.repaint();


        this.setSize(400, 300);
        getContentPane().setLayout(
                new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
        );

        for (LinkedList<String> savedGame : savedGames){
            SavedGameLabel savedGameLabel = new SavedGameLabel(savedGame.get(0)+"        "+savedGame.get(1), this);
            savedGameLabel.addMouseListener(savedGameLabel);
            savedGameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(savedGameLabel);
            this.revalidate();
            this.repaint();
        }

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

}
