package Logic.Game.Models.Bricks;

public enum BrickType {
    GLASSY_BRICK(1),
    WOODEN_BRICK(2),
    INVISIBLE_BRICK(3),
    BLINKER_BRICK(4),
    PRIZE_BRICK(5);

    private final int brickNumber;

    BrickType(int brickNumber) {
        this.brickNumber = brickNumber;
    }

    public int getBrickNumber() {
        return brickNumber;
    }
}
