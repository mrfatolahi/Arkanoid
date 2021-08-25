package Logic.Savers;

import Logic.Game.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class HighScoresSaver {

    public static void saveHighScore(Game game) throws FileNotFoundException {
        File file = new File("Database/ManagerInf/HighScores");
        Scanner scanner = new Scanner(file);
        LinkedList<LinkedList<String>> highScores = new LinkedList<>();

        while (scanner.hasNext()){
            LinkedList<String> highScore = new LinkedList();
            highScore.add(scanner.next());
            highScore.add(scanner.next());
            highScores.add(highScore);
        }

        for (int i = 0; i < highScores.size(); i++) {
            if(game.getPlayer_score() > Integer.parseInt(highScores.get(i).get(1))){
                if(i != highScores.size() - 1){
                    if(game.getPlayer_score() > Integer.parseInt(highScores.get(i+1).get(1))){
                        continue;
                    }
                }
                highScores.remove(i);
                LinkedList<String> newHighScore = new LinkedList();
                newHighScore.add(game.getName());
                newHighScore.add(String.valueOf(game.getPlayer_score()));

                highScores.add(i, newHighScore);
                break;
            }
        }
        FileOutputStream fount = new FileOutputStream(file , false);
        PrintStream writer  = new PrintStream(fount);
        for (LinkedList<String> highScore : highScores) {
            writer.print(highScore.get(0) + " " + highScore.get(1) + "\n");
        }
    }
}
