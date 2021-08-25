package Logic.Loaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ManagerInfLoader {

    public ArrayList<ArrayList<String>> loadHighScores() throws FileNotFoundException {
        File file = new File("Database/ManagerInf/HighScores");
        Scanner scanner = new Scanner(file);
        ArrayList<ArrayList<String>> highScores = new ArrayList<>();

        while (scanner.hasNext()){
            ArrayList<String> highScore = new ArrayList();
            highScore.add(scanner.next());
            highScore.add(scanner.next());
            highScores.add(highScore);
        }

        return highScores;
    }
}
