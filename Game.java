package animalchess;
/**
 * Main entry into the game.
 */
public class Game {
    /** rows. */
    static final int HEIGHT = 6;
    /** columns. */
    static final int WIDTH = 5;
    /**Players. */
    protected Player p0, p1;
    /** 2D array to keep track of Game. */
    private Square[][] board = new Square[HEIGHT][WIDTH];
    /**
     * Constructors initiates the board and places pieces.
     * @param p0 player 0
     * @param p1 player 1
     */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;
        for (int row = 1; row < HEIGHT - 1; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (row == 1) {
                    Square nullpSquare = new Square(this, row, col, p1);
                    board[row][col] = nullpSquare;
                }
                else if (row == 4) {
                    Square nullpSquare = new Square(this, row, col, p0);
                    board[row][col] = nullpSquare;
                }
                else {
                    Square nullSquare = new Square(this, row, col);
                    board[row][col] = nullSquare;
                }
            }
        }

        Square catl0s = new Square(this, 0, 0, p1);
        Piece catl0p = new Cat(p0, catl0s);
       // catl0s.placePiece(catl0p);
        board[0][0] = catl0s;

        Square girafl0s = new Square(this, 0, 1, p1);
        Piece girafl0p = new Giraffe(p0, girafl0s);
       // girafl0s.placePiece(girafl0p);
        board[0][1] = girafl0s;

        Square lion0s = new Square(this, 0, 2, p1);
        Piece lion0p = new Lion(p0, lion0s);
      //  lion0s.placePiece(lion0p);
        board[0][2] = lion0s;

        Square girafr0s = new Square(this, 0, 3, p1);
        Piece girafr0p = new Giraffe(p0, girafr0s);
      //  girafr0s.placePiece(girafr0p);
        board[0][3] = girafr0s;

        Square catr0s = new Square(this, 0, 4, p1);
        Piece catr0p = new Cat(p0, catr0s);
       // catr0s.placePiece(catr0p);
        board[0][4] = catr0s;

        Square chickl0s = new Square(this, 2, 1);
        Piece chickl0p = new Chick(p0, chickl0s);
       // chickl0s.placePiece(chickl0p);
        board[2][1] = chickl0s;

        Square chickm0s = new Square(this, 2, 2);
        Piece chickm0p = new Chick(p0, chickm0s);
       // chickm0s.placePiece(chickm0p);
        board[2][2] = chickm0s;

        Square chickr0s = new Square(this, 2, 3);
        Piece chickr0p = new Chick(p0, chickr0s);
      //  chickr0s.placePiece(chickr0p);
        board[2][3] = chickr0s;

        Square chickl1s = new Square(this, 3, 1);
        Piece chickl1p = new Chick(p1, chickl1s);
      //  chickl1s.placePiece(chickl1p);
        board[3][1] = chickl1s;

        Square chickm1s = new Square(this, 3, 2);
        Piece chickm1p = new Chick(p1, chickm1s);
      //  chickm1s.placePiece(chickm1p);
        board[3][2] = chickm1s;

        Square chickr1s = new Square(this, 3, 3);
        Piece chickr1p = new Chick(p1, chickr1s);
      //  chickr1s.placePiece(chickr1p);
        board[3][3] = chickr1s;

        Square catl1s = new Square(this, 5, 0, p0);
        Piece catl1p = new Cat(p1, catl1s);
      //  catl1s.placePiece(catl1p);
        board[5][0] = catl1s;

        Square girafl1s = new Square(this, 5, 1, p0);
        Piece girafl1p = new Giraffe(p1, girafl1s);
      //  girafl1s.placePiece(girafl1p);
        board[5][1] = girafl1s;

        Square lion1s = new Square(this, 5, 2, p0);
        Piece lion1p = new Lion(p1, lion1s);
       // lion1s.placePiece(lion1p);
        board[5][2] = lion1s;

        Square girafr1s = new Square(this, 5, 3, p0);
        Piece girafr1p = new Giraffe(p1, girafr1s);
       // girafr1s.placePiece(girafr1p);
       board[5][3] = girafr1s;

        Square catr1s = new Square(this, 5, 4, p0);
        Piece catr1p = new Cat(p1, catr1s);
       // catr1s.placePiece(catr1p);
       board[5][4] = catr1s;
    }

    /**
     * Change board using square.
     * @param old old piece
     * @param fresh new piece
     */
    public void updateboard(Square old, Square fresh) {
        int row1 = old.getRow();
        int col1 = old.getCol();

        int row2 = fresh.getRow();
        int col2 = fresh.getCol();

        Square nullSquare = new Square(this, row1, col1);

        board[row1][col1] = nullSquare;

        board[row2][col2] = fresh;
    }
    /**
     * Change board using row and col.
     * @param row row
     * @param col col
     */
    public void updateboard(int row, int col) {
        Square nullSquare = new Square(this, row, col);
        board[row][col] = nullSquare;
    }
    /**
     * getPlayer of game.
     * @param playerNumber interger
     */
    public Player getPlayer(int playerNumber) {
        if  (this.p0.playerNumber == playerNumber) {
            return p0;
        }
        else if  (this.p1.playerNumber == playerNumber) {
            return p1;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * get Winner of game.
     */
    public Player getWinner() {
        if (this.p0.hasWon()) {
            return p0;
        }
        else if  (this.p1.hasWon()) {
            return p1;
        }
        else {
            return null;
        }
    }
    /**
     * Change board using row and col.
     * @param row row
     * @param col col
     */
    public Square getSquare(int row, int col) {
        Square result = board[row][col];
        return result;
    }
}
