package Logic;

import graphic.MainFrame;
import Logic.Game.Game;
import Logic.Loaders.GameLoader;
import Logic.Loaders.ManagerInfLoader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Manager {
    private final MainFrame mainFrame;
    private final ManagerInfLoader infLoader;
    private Game game;
    private ArrayList<ArrayList<String>> highScores;

    public Manager() throws FileNotFoundException {
        this.infLoader = new ManagerInfLoader();
        this.highScores = infLoader.loadHighScores();
        this.mainFrame = new MainFrame(this);
    }

    public void startNewGame(){
        Game newGame = new Game();
        this.game = newGame;
        this.mainFrame.getGamePanel().start(newGame);
    }

    public void startSavedGame(String name, int ID) throws FileNotFoundException {
        Game savedGame = new Game();
        savedGame.setID(ID);
        savedGame.setName(name);
        GameLoader gameLoader = new GameLoader();
        gameLoader.loadGameInformation(savedGame);
        this.game = savedGame;
        this.mainFrame.getGamePanel().start(savedGame);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public Game getGame() {
        return game;
    }

    public ManagerInfLoader getInfLoader() {
        return infLoader;
    }

    public ArrayList<ArrayList<String>> getHighScores() {
        return highScores;
    }
}
