package graphic.panels;

import graphic.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HighScoresPanel extends JPanel {
    private final MainFrame mainFrame;

    public HighScoresPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(800, 300, 150, 300);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel textLabel = new JLabel(" HIGH  SCORES");
        textLabel.setFont(new Font("Bodoni MT Black", Font.PLAIN, 15));
        textLabel.setForeground(Color.WHITE);
        textLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(textLabel);

        this.add(Box.createRigidArea(new Dimension(0,40)));

        for (ArrayList<String> highScore : mainFrame.getManager().getHighScores()){
            JLabel label = new JLabel(" "+highScore.get(0)+"              "+highScore.get(1)+" ");
            label.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 17));
            label.setForeground(Color.WHITE);
            label.setBackground(Color.MAGENTA);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(label);
            this.add(Box.createRigidArea(new Dimension(0,10)));
        }
    }
}
