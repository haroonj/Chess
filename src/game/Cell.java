package game;

import models.pieces.Piece;

public class Cell {
    private final int x;
    private final int y;

    private Piece piece;
    public Cell(int x, int y,Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        piece=null;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Piece getPiece() {
        return piece;
    }
    public void killPiece(){
        piece.kill();
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    @Override
    public String toString() {
        return piece==null?"Empty ":piece +" ";
    }
}
