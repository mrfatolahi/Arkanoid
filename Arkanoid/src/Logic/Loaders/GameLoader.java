package Logic.Loaders;

import Logic.Game.Game;
import Logic.Game.Models.Ball;
import Logic.Game.Models.Bricks.*;
import Logic.Game.Models.Prizes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GameLoader {

    public static LinkedList<LinkedList<String>> loadSavedGames() throws FileNotFoundException {
        LinkedList<LinkedList<String>> savedGames = new LinkedList<>();
        File savedGamesDir = new File("Database\\GamesID\\");

        for (File file : savedGamesDir.listFiles()){
            Scanner scanner = new Scanner(file);
            scanner.next();
            LinkedList<String> savedGame = new LinkedList<>();
            savedGame.add(String.valueOf(file.getName()).substring(0, String.valueOf(file.getName()).length()-4));

            savedGame.add(scanner.next()+" at "+ scanner.next());
            savedGames.add(savedGame);
        }

        return savedGames;
    }

    public static int loadID(String name) throws FileNotFoundException {
        File IDfile = new File("Database\\GamesID\\"+name+".txt");
        Scanner scanner = new Scanner(IDfile);
        return scanner.nextInt();
    }


    public void loadGameInformation(Game game) throws FileNotFoundException {
        game.setName(loadName(game));
        game.setLifes_left(loadLifesLeft(game));
        game.setBalls(loadBalls(game));
        game.getMapGenerator().setRows(loadMapGenerator(game));
        loadBoard(game);
        game.setPlayer_score(loadPlayerScore(game));
        game.setReleasedPrizes(loadReleasedPrizes(game));

    }
    public String  loadName(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\Name.txt");
        Scanner scanner = new Scanner(file);
        return scanner.next();
    }


    public int loadLifesLeft(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\LifesLeft.txt");
        Scanner scanner = new Scanner(file);
        return scanner.nextInt();
    }

    public LinkedList<Ball> loadBalls(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\Balls.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<Ball> balls = new LinkedList<>();
        while (game.getBalls().size() != 0){
            game.getBalls().removeLast();
        }
        while (scanner.hasNext()){
            Ball ball = new Ball(game);
            ball.setBallX(scanner.nextInt());
            ball.setBallY(scanner.nextInt());
            ball.setVelocityX(scanner.nextInt());
            ball.setVelocityY(scanner.nextInt());
            ball.setFiery(scanner.next().equals("true"));
            balls.add(ball);
        }
        return balls;
    }

    public LinkedList<LinkedList<Brick>> loadMapGenerator(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\MapGenerator.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<LinkedList<Brick>> rows = new LinkedList<>();
        while (scanner.hasNext()){
            LinkedList<Brick> row = new LinkedList<>();
            for (int i = 0; i < 7; i++) {
                String brickType = scanner.next();
                switch (brickType){
                    case "GLASSY_BRICK":
                        GlassyBrick glassyBrick = new GlassyBrick(scanner.nextInt(), scanner.nextInt());
                        if (scanner.next().equals("true")){
                            glassyBrick.destroy();
                        }
                        row.add(glassyBrick);
                        break;
                    case "WOODEN_BRICK":
                        WoodenBrick woodenBrick = new WoodenBrick(scanner.nextInt(), scanner.nextInt());
                        if (scanner.next().equals("true")){
                            woodenBrick.destroy();
                        }
                        row.add(woodenBrick);
                        break;
                    case "INVISIBLE_BRICK":
                        InvisibleBrick invisibleBrick = new InvisibleBrick(scanner.nextInt(), scanner.nextInt());
                        if (scanner.next().equals("true")){
                            invisibleBrick.destroy();
                        }
                        row.add(invisibleBrick);
                        break;
                    case "BLINKER_BRICK":
                        BlinkerBrick blinkerBrick = new BlinkerBrick(scanner.nextInt(), scanner.nextInt());
                        if (scanner.next().equals("true")){
                            blinkerBrick.destroy();
                        }
                        row.add(blinkerBrick);
                        break;
                    case "PRIZE_BRICK":
                        PrizeBrick prizeBrick = new PrizeBrick(scanner.nextInt(), scanner.nextInt());
                        if (scanner.next().equals("true")){
                            prizeBrick.destroy();
                        }
                        row.add(prizeBrick);
                        break;
                }
            }
            rows.add(row);
        }
        return rows;
    }

    public void loadBoard(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\Board.txt");
        Scanner scanner = new Scanner(file);
        game.getBoard().setBoardX(scanner.nextInt());
        game.getBoard().setWidth(scanner.nextInt());
        game.getBoard().setCrazy(scanner.next().equals("true"));
    }

    public int loadPlayerScore(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\PlayerScore.txt");
        Scanner scanner = new Scanner(file);
        return scanner.nextInt();
    }

    public LinkedList<Prize> loadReleasedPrizes(Game game) throws FileNotFoundException {
        File file = new File("Database\\Games\\"+game.getID()+"\\ReleasedPrizes.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<Prize> prizes = new LinkedList<>();
        while (scanner.hasNext()){
            String prizeType = scanner.next();
            switch (prizeType){
                case "FIERY_BALL":
                    FieryBall fieryBall = new FieryBall(null);
                    fieryBall.setPrizeX(scanner.nextInt());
                    fieryBall.setPrizeY(scanner.nextInt());
                    prizes.add(fieryBall);
                    break;
                case "MULTIPLE_BALLS":
                    MultipeBalls multipeBalls = new MultipeBalls(null);
                    multipeBalls.setPrizeX(scanner.nextInt());
                    multipeBalls.setPrizeY(scanner.nextInt());
                    prizes.add(multipeBalls);
                    break;
                case "BIG_BOARD":
                    BigBoard bigBoard = new BigBoard(null);
                    bigBoard.setPrizeX(scanner.nextInt());
                    bigBoard.setPrizeY(scanner.nextInt());
                    prizes.add(bigBoard);
                    break;
                case "SMALL_BOARD":
                    SmallBoard smallBoard = new SmallBoard(null);
                    smallBoard.setPrizeX(scanner.nextInt());
                    smallBoard.setPrizeY(scanner.nextInt());
                    prizes.add(smallBoard);
                    break;
                case "FAST_BALL":
                    FastBall fastBall = new FastBall(null);
                    fastBall.setPrizeX(scanner.nextInt());
                    fastBall.setPrizeY(scanner.nextInt());
                    prizes.add(fastBall);
                    break;
                case "CRAZY_BOARD":
                    CrazyBoard crazyBoard = new CrazyBoard(null);
                    crazyBoard.setPrizeX(scanner.nextInt());
                    crazyBoard.setPrizeY(scanner.nextInt());
                    prizes.add(crazyBoard);
                    break;
                case "RANDOM_PRIZE":
                    RandomPrize randomPrize = new RandomPrize(null);
                    randomPrize.setPrizeX(scanner.nextInt());
                    randomPrize.setPrizeY(scanner.nextInt());
                    prizes.add(randomPrize);
                    break;
                case "SLOW_BALL":
                    SlowBall slowBall = new SlowBall(null);
                    slowBall.setPrizeX(scanner.nextInt());
                    slowBall.setPrizeY(scanner.nextInt());
                    prizes.add(slowBall);
                    break;

            }
        }
        return prizes;
    }

}
