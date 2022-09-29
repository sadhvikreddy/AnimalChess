package animalchess;

public abstract class PromotablePiece extends Piece {
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
    }
    public boolean getIsPromoted() {
        return super.promoted;
    }
    public void promote() {
        super.promoted = true;
    }
    public void demote() {
        super.promoted = false;
    }
    public void move(Square tosquare) {
        if (tosquare.isPromotionZone(this.owner)) {
            this.promote();
         }
         super.move(tosquare);
    }
    public void beCaptured(Player capturer) {
        if (this.getIsPromoted()) {
            this.demote();
        }
        this.owner = capturer;
    }
}
