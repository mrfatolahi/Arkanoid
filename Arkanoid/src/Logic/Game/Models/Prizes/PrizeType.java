package Logic.Game.Models.Prizes;

public enum PrizeType {
    FIERY_BALL(1),
    MULTIPLE_BALLS(2),
    BIG_BOARD(3),
    SMALL_BOARD(4),
    FAST_BALL(5),
    CRAZY_BOARD(6),
    RANDOM_PRIZE(7),
    SLOW_BALL(8);

    private final int prizeNumber;

    PrizeType(int prizeNumber) {
        this.prizeNumber = prizeNumber;
    }

    public int getPrizeNumber() {
        return prizeNumber;
    }

    public static PrizeType getPrizeTypeByPrizeNumber(int prizeNumber){
        return switch (prizeNumber) {
            case 1 -> PrizeType.FIERY_BALL;
            case 2 -> PrizeType.MULTIPLE_BALLS;
            case 3 -> PrizeType.BIG_BOARD;
            case 4 -> PrizeType.SMALL_BOARD;
            case 5 -> PrizeType.FAST_BALL;
            case 6 -> PrizeType.CRAZY_BOARD;
            case 7 -> PrizeType.RANDOM_PRIZE;
            case 8 -> PrizeType.SLOW_BALL;
            default -> null;
        };
    }
}
