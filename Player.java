package animalchess;

import java.util.ArrayList;

public class Player {
    protected int playerNumber;
    protected String name;
    protected Boolean winner = false;
    protected ArrayList<Piece> hand = new ArrayList<Piece>();

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public ArrayList<Piece> getHand() {
        return hand;
    }

    public void addPieceToHand(Piece piece) {
        if (piece.promoted) {
            piece.promoted = false;
        }
        piece.getSquare().removePiece();
        hand.add(piece);
    }

    public void dropPiece(Piece piece, Square square) {
        hand.remove(piece);
        square.placePiece(piece);
    }

    public void winGame() {
        this.winner = true;
    }

    public boolean hasWon() {
        return this.winner;
    }

}
