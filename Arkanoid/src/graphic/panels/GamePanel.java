package graphic.panels;

import graphic.MainFrame;
import graphic.painters.BallPainter;
import graphic.painters.BoardPainter;
import graphic.painters.MapPainter;
import graphic.painters.PrizePainter;
import Logic.Game.Game;
import Logic.Game.Models.Ball;
import Logic.Game.Models.Prizes.Prize;
import Logic.Savers.HighScoresSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final MainFrame mainFrame;
    private Game game;
    private final BallPainter ballPainter;
    private final MapPainter mapPainter;
    private final BoardPainter boardPainter;
    private final PrizePainter prizePainter;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final Timer timer;



    public GamePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setBounds(0, 0, WIDTH, HEIGHT);
        ImageIcon imageIcon = new ImageIcon("480px-Eo_circle_brown_letter-a.svg.png");
        this.timer = new Timer(8, this);

        this.game = null;
        this.prizePainter = new PrizePainter(this);
        this.ballPainter = new BallPainter(this);
        this.mapPainter = new MapPainter(this);
        this.boardPainter = new BoardPainter(this);
    }

    public void start(Game game){
        this.game = game;
        this.game.setStarted(true);
        timer.start();
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public void paint(Graphics g) {

        if(this.game == null){
            Image image = new ImageIcon("Google-Abstract-Triangle-Background-wallpapers.jpg").getImage();
            g.drawImage(image, -980, -250, null);
        }else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 600);

            g.setColor(Color.RED);
            g.fillRect(0, 450, 800, 1);

            g.setColor(Color.yellow);
            g.fillRect(0, 0, 800, 10);
            g.fillRect(790, 0, 10, 600);
            g.fillRect(0, 0, 10, 600);

            g.setColor(Color.BLUE);
            g.setFont(new Font("Bodoni MT Black", Font.PLAIN, 15));

            g.drawString(" Score: " + mainFrame.getManager().getGame().getPlayer_score(), 10, 470);
            g.drawString("Lifes: " + mainFrame.getManager().getGame().getLifes_left(), 720, 470);

            this.mapPainter.paint(g);
            this.prizePainter.paint(g);
            this.ballPainter.paint(g);
            this.boardPainter.paint(g);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        for (Prize prize : game.getReleasedPrizes()){
            prize.move(game);
        }
        for (Ball ball : game.getBalls()){
            ball.move();
        }
        game.checkForEndGame();
        if (game.isFinished()){
            String name = JOptionPane.showInputDialog("Enter your name to add your score to highscores");
            game.setName(name);
            try {
                HighScoresSaver.saveHighScore(game);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            System.exit(0);
        }
        this.repaint();
        this.revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.game == null){
            return;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.getBoard().moveRight();
        }else
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            game.getBoard().moveLeft();
        }
        this.repaint();
        this.revalidate();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Game getGame() {
        return game;
    }


}
