package movement;

import game.Board;
import game.Cell;
import models.pieces.Piece;

public class Move {
    private final Cell startCell;
    private Cell endCell;

    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public Cell getStartCell() {
        return startCell;
    }
    public Cell getEndCell() {
        return endCell;
    }
    public void setEndCell(Cell endCell) {
        this.endCell = endCell;
    }

    public int absHorizontalDifferance(){
        return Math.abs((startCell.getY()-endCell.getY()));
    }
    public boolean validateTheMove(){
        Piece piece = Board.getBoard().getPiece(startCell.getX(),startCell.getY());

        return piece != null && piece.canMove(this);
    }
}
