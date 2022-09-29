package animalchess;

public class Square {
    protected Game game;

    protected Piece curResident;
    protected int row;
    protected int col;
    protected Player promotesPlayer;


    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
    }

    public void placePiece(Piece piece) {
        if (this.game != null) {
            try {
            this.game.updateboard(piece.getSquare(), this);
            }
            catch (NullPointerException e) { }
        }
        if (this.curResident != null) {
            if (this.getPiece().getOwner().equals(piece.getOwner())) {
                throw new IllegalArgumentException();
            }
        }
        this.curResident = piece;
        //    System.out.println(this.getCol());
    }

    public void removePiece() {
        if (this.game != null) {
            this.game.updateboard(this.getRow(), this.getCol());
        }
        this.curResident = null;
    }

    public boolean isPromotionZone(Player player) {
        Player p = this.promotesPlayer;
        try { 
        if (p.equals(player)) {
            return true;
        }
        else {
            return false;
        }
    } catch (NullPointerException e) {
        return false;
    }
    }

    public Game getGame() {
        return this.game;
    }

    public Piece getPiece() {
        if (this.curResident == null) {
            return null;
        }
        else {
            return this.curResident;
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public Player getPromPlayer() {
        return this.promotesPlayer;
    }
}
