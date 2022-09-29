package animalchess;

import java.util.ArrayList;
/**
 * Piece.
 */
public abstract class Piece {
    /**owner. */
    protected Player owner;
    /**Square. */
    private Square square;
    /**promoted. */
    protected boolean promoted = false;
    /**
     * Constructor.
     * @param owner owner
     * @param square square
     */
    public Piece(Player owner, Square square) {
        this.owner = owner;
        this.square = square;
        this.square.placePiece(this);
    }
    /**
     * To check Square.
     * @param sq square
     * @param num player number
     * @return legalsquare
     */
    public boolean checkLegalSquare(Square sq, int num) {
        if  (!checkOutOfBoundsSquare(sq.getRow(), sq.getCol())) {
            return false;
        }
        try {
            if  (sq.getPiece().getOwner().playerNumber == num) {
                return false;
            }
        } catch (NullPointerException nullpointer) {
            return true;
        }
        return true;
    }
    /**
     * To out of range.
     * @param row r
     * @param col c
     * @return legalSquare
     */
    public boolean checkOutOfBoundsSquare(int row, int col) {
        if  (row < 0 || col < 0) {
            return false;
        }
        if  (row >= Game.HEIGHT || col >= Game.WIDTH) {
            return false;
        }
        return true;
    }
    /**
     * Legal moves
     * @return legal moves
     */
    public ArrayList<Square> getLegalMoves() {
        try {
            int row = this.square.getRow();
            int col = this.square.getCol();
            Game game = this.square.getGame();
            Square step_back_left = new Square(null, 99, 99);
            Square step_back =  new Square(null, 99, 99);
            Square step_back_right =  new Square(null, 99, 99);

            Square step_left =  new Square(null, 99, 99);
            Square step_right =  new Square(null, 99, 99);

            Square step_up_left =  new Square(null, 99, 99);
            Square step_up =  new Square(null, 99, 99);
            Square step_up_right =  new Square(null, 99, 99);

            if  (checkOutOfBoundsSquare(row - 1, col - 1)) {
                step_back_left = game.getSquare(row - 1, col - 1);
            }
            if  (checkOutOfBoundsSquare(row - 1, col)) {
                step_back = game.getSquare(row - 1, col);
            }
            if  (checkOutOfBoundsSquare(row - 1, col + 1)) {
                step_back_right = game.getSquare(row - 1, col + 1);
            }
            if  (checkOutOfBoundsSquare(row, col - 1)) {
                step_left = game.getSquare(row, col - 1);
            }
            if  (checkOutOfBoundsSquare(row, col + 1)) {
                step_right = game.getSquare(row, col + 1);
            }

            if  (checkOutOfBoundsSquare(row + 1, col - 1)) {
                step_up_left = game.getSquare(row + 1, col - 1);
            }
            if  (checkOutOfBoundsSquare(row + 1, col)) {
                step_up = game.getSquare(row + 1, col);
            }
            if  (checkOutOfBoundsSquare(row + 1, col + 1)) {
                step_up_right = game.getSquare(row + 1, col + 1);
            }

            ArrayList<Square> moves = new ArrayList<Square>();
            String selector = this.getClass().getName();
            int indexof = selector.indexOf(".");
            selector = selector.substring(indexof + 1);

            int num = this.owner.getPlayerNumber();

            switch(selector) {
                case "Chick": {
                    if  (this.promoted) {
                        if (num == 0) {
                            if  (checkLegalSquare(step_back, num)) {
                                moves.add(step_back);
                            }
                            if  (checkLegalSquare(step_left, num)) {
                                moves.add(step_left);
                            }
                            if  (checkLegalSquare(step_right, num)) {
                                moves.add(step_right);
                            }
                            if  (checkLegalSquare(step_up_left, num)) {
                                moves.add(step_up_left);
                            }
                            if  (checkLegalSquare(step_up, num)) {
                                moves.add(step_up);
                            }
                            if  (checkLegalSquare(step_up_right, num)) {
                                moves.add(step_back_right);
                            }
                            return moves;
                        }
                        else if (num == 1) {
                            if  (checkLegalSquare(step_back, num)) {
                                moves.add(step_back);
                            }
                            if  (checkLegalSquare(step_left, num)) {
                                moves.add(step_left);
                            }
                            if  (checkLegalSquare(step_right, num)) {
                                moves.add(step_right);
                            }
                            if  (checkLegalSquare(step_back_left, num)) {
                                moves.add(step_up_left);
                            }
                            if  (checkLegalSquare(step_up, num)) {
                                moves.add(step_up);
                            }
                            if  (checkLegalSquare(step_back_right, num)) {
                                moves.add(step_back_right);
                            }
                            return moves;
                        }
                    }
                    else {
                        if  (num == 0) {
                            if  (checkLegalSquare(step_up, num)) {
                                moves.add(step_up);
                            }
                            return moves;
                        }
                        else if  (num == 1) {
                            if  (checkLegalSquare(step_back, num)) {
                                moves.add(step_back);
                            }
                            return moves;
                        }
                    }
                }

                case "Cat": {
                    if  (this.promoted) {
                        if (num == 0) {
                            if (checkLegalSquare(step_back, num)) {
                                moves.add(step_back);
                            }
                            if (checkLegalSquare(step_left, num)) {
                                moves.add(step_left);
                            }
                            if (checkLegalSquare(step_right, num)) {
                                moves.add(step_right);
                            }
                            if (checkLegalSquare(step_up_left, num)) {
                                moves.add(step_up_left);
                            }
                            if (checkLegalSquare(step_up, num)) {
                                moves.add(step_up);
                            }
                            if (checkLegalSquare(step_up_right, num)) {
                                moves.add(step_back_right);
                            }
                            return moves;
                        }
                        else if (num == 1) {
                            if (checkLegalSquare(step_back, num)) {
                                moves.add(step_back);
                            }
                            if (checkLegalSquare(step_left, num)) {
                                moves.add(step_left);
                            }
                            if (checkLegalSquare(step_right, num)) {
                                moves.add(step_right);
                            }
                            if (checkLegalSquare(step_back_left, num)) {
                                moves.add(step_up_left);
                            }
                            if (checkLegalSquare(step_up, num)) {
                                moves.add(step_up);
                            }
                            if (checkLegalSquare(step_back_right, num)) {
                                moves.add(step_back_right);
                            }
                            return moves;
                        }
                    }
                    else {
                        if  (num == 0) {
                            if  (checkLegalSquare(step_up_left, num)) {
                                moves.add(step_up_left);
                            }
                            if  (checkLegalSquare(step_up, num)) {
                                moves.add(step_up);
                            }
                            if  (checkLegalSquare(step_up_right, num)) {
                                moves.add(step_up_right);
                            }
                            if  (checkLegalSquare(step_back_left, num)) {
                                moves.add(step_back_left);
                            }
                            if (checkLegalSquare(step_back_right, num)) {
                                moves.add(step_back_right);
                            }
                            return moves;
                        }
                        else if (num == 1) {
                            if (checkLegalSquare(step_up_left, num)) {
                                moves.add(step_up_left);
                            }
                            if (checkLegalSquare(step_back, num)) {
                                moves.add(step_back);
                            }
                            if (checkLegalSquare(step_up_right, num)) {
                                moves.add(step_up_right);
                            }
                            if (checkLegalSquare(step_back_left, num)) {
                                moves.add(step_back_left);
                            }
                            if (checkLegalSquare(step_back_right, num)) {
                                moves.add(step_back_right);
                            }
                            return moves;
                        }
                    }
                }
                case "Giraffe": {
                    if (checkLegalSquare(step_up, num)) {
                        moves.add(step_up);
                    }
                    if (checkLegalSquare(step_left, num)) {
                        moves.add(step_left);
                    }
                    if (checkLegalSquare(step_right, num)) {
                        moves.add(step_right);
                    }
                    if (checkLegalSquare(step_back, num)) {
                        moves.add(step_back);
                    }
                    return moves;
                }
                case "Lion": {
                    if (checkLegalSquare(step_up_left, num)) {
                        moves.add(step_up_left);
                    }
                    if (checkLegalSquare(step_up, num)) {
                        moves.add(step_up);
                    }
                    if (checkLegalSquare(step_up_right, num)) {
                        moves.add(step_up_right);
                    }
                    if (checkLegalSquare(step_left, num)) {
                        moves.add(step_left);
                    }
                    if (checkLegalSquare(step_right, num)) {
                        moves.add(step_right);
                    }
                    if (checkLegalSquare(step_back_left, num)) {
                        moves.add(step_back_left);
                    }
                    if (checkLegalSquare(step_back, num)) {
                        moves.add(step_back);
                    }
                    if (checkLegalSquare(step_back_right, num)) {
                        moves.add(step_back_right);
                    }
                    return moves;
                }
                default : {
                    return moves;
                }
            }
        } catch (NullPointerException e) {
            ArrayList<Square> a = new ArrayList<Square>();
            return a;
        }
        }

    public void move(Square tosquare) {
        Piece tobecaptured = tosquare.getPiece();
        if (tobecaptured != null) {
            try {
                if (tobecaptured.getOwner().equals(this.getOwner())) {
                    throw new IllegalArgumentException();
                }
                else {
                    this.getOwner().addPieceToHand(tobecaptured);
                    tobecaptured.owner = this.getOwner();
                    if (tobecaptured instanceof Lion) {
                        this.getOwner().winGame();
                    }
                  //  Square nullsquare = new Square(tosquare.getGame(), tobecaptured.getSquare().getRow(), tobecaptured.getSquare().getRow());
                    tobecaptured.square = null;
                    tosquare.removePiece();
                    tosquare.placePiece(this);
                    this.square = tosquare;
                }
            }
            catch (IllegalArgumentException ignored) { }
        }
        else {
            this.square.removePiece();
            tosquare.placePiece(this);
            this.square = tosquare;
        }
    }

    public void beCaptured(Player capturer) {
        this.owner = capturer;
    }

    public Square getSquare() {
        return this.square;
    }
  
    public Player getOwner() {
        return this.owner;
    }
}
