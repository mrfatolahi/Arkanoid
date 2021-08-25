package graphic.savedGamesFrame;

import Logic.Loaders.GameLoader;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class SavedGameLabel extends JLabel implements MouseListener {
    private final SavedGamesFrame savedGamesFrame;

    public SavedGameLabel(String text, SavedGamesFrame savedGamesFrame) {
        this.setFocusable(false);
        this.savedGamesFrame = savedGamesFrame;
        this.setText(text);
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            String name = "";
            for (int i = 0; i < this.getText().length(); i++) {
                if(this.getText().charAt(i) == ' '){break;}
                name = name + this.getText().charAt(i);
            }
            savedGamesFrame.getMainFrame().getManager().startSavedGame(this.getText(), GameLoader.loadID(name));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        savedGamesFrame.dispatchEvent(new WindowEvent(savedGamesFrame, WindowEvent.WINDOW_CLOSING));
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
