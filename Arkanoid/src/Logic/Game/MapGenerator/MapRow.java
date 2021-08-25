package Logic.Game.MapGenerator;

import Logic.Game.Models.Bricks.BrickType;

import java.util.LinkedList;
import java.util.Random;

public class MapRow extends LinkedList<BrickType> {

    public MapRow() {
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int brickType = random.nextInt(5) + 1;

            switch (brickType) {
                case 1 -> this.add(BrickType.GLASSY_BRICK);
                case 2 -> this.add(BrickType.WOODEN_BRICK);
                case 3 -> this.add(BrickType.INVISIBLE_BRICK);
                case 4 -> this.add(BrickType.BLINKER_BRICK);
                case 5 -> this.add(BrickType.PRIZE_BRICK);
            }
        }
    }

}
