package Logic.Savers;


import Logic.Game.Game;
import Logic.Game.Models.Ball;
import Logic.Game.Models.Bricks.Brick;
import Logic.Game.Models.Prizes.Prize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class GameSaver {


    public static void saveGame(Game game, String name) throws IOException {
        game.setName(name);
        File directory = new File("Database\\Games\\"+game.getID());
        if (!directory.exists()){
            directory.mkdirs();
        }
        saveID(game);
        saveName(game);
        saveLifesLeft(game);
        saveBalls(game);
        saveMapGenerator(game);
        saveboard(game);
        savePlayerScore(game);
        saveReleasedPrizes(game);
    }

    public static void saveID(Game game) throws IOException {
        File ID = new File("Database\\GamesID\\"+game.getName()+".txt");
        if(!ID.exists()){ID.createNewFile();}
        FileOutputStream fount = new FileOutputStream(ID , false);
        PrintStream writer  = new PrintStream(fount);
        writer.print(game.getID());
        writer.println();
        writer.println(LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getDayOfMonth());
        writer.println(LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
    }

    public static void saveName(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\Name.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        writer.print(game.getName());
    }

    public static void saveLifesLeft(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\LifesLeft.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        writer.print(game.getLifes_left());
    }

    public static void saveBalls(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\Balls.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        for (Ball ball : game.getBalls()) {
            writer.print(ball.getBallX()+" "+ ball.getBallY()+" "+ ball.getVelocityX()+" "
                    + ball.getVelocityY()+" "+ball.isFiery()+"\n");
        }
    }

    public static void saveMapGenerator(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\MapGenerator.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        for (LinkedList<Brick> row : game.getMapGenerator().getRows()){
            for (Brick brick : row){
                writer.print(brick.getBrickType()+" "+brick.getX()+" "+ brick.getY()+" "+brick.isDestroyed()+" ");
            }
            writer.println();
        }
    }

    public static void saveboard(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\Board.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        writer.print(game.getBoard().getBoardX()+" "+game.getBoard().getWidth()+" "+game.getBoard().isCrazy());
    }

    public static void savePlayerScore(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\PlayerScore.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        writer.print(game.getPlayer_score());
    }

    public static void saveReleasedPrizes(Game game) throws IOException {
        File file = new File("Database\\Games\\"+game.getID()+"\\ReleasedPrizes.txt");
        if(!file.exists()){file.createNewFile();}
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        for (Prize prize : game.getReleasedPrizes()){
            writer.print(prize.getPrizeType()+" "+prize.getPrizeX()+" "+prize.getPrizeY());
            writer.println();
        }

    }

}
