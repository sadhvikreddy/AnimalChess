package animalchess;
/**
 * Piece Lion.
 */
public class Lion extends Piece {
    /**
     * Constructor.
     * @param owner
     * @param square
     */
    public Lion(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Lion captured: Wins Game.
     * @param capturer
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        capturer.winGame();
    }
}
