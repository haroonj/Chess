package movement;

import game.Board;
import game.Cell;
import models.pieces.Piece;

public class CastlingHandler extends MovementHandler{
    @Override
    public void handle(Move move) {
        Piece piece = Board.getBoard().getPiece(
                move.getStartCell().getX(),
                move.getStartCell().getY()
                );
        if(piece !=null &&  Board.getBoard().canCastle(piece) && !Board.getBoard().kingIsUnderAttack()){
            if(
                    move.absHorizontalDifferance() == 2

            ){
                castling(move,piece);
                return;
            }
        }
            if(nextHandler!=null)
                nextHandler.handle(move);
            else
                System.out.println("Request cannot be handled");
    }
    private void castling(Move move, Piece piece){
        Board.getBoard().setPieceInBoard(move);
        Board.getBoard().disableCastling(piece);
        Move casMove;
        //short castle 0-0
        if(move.getEndCell().getY()==6) {
             casMove = new Move(
                    new Cell(move.getEndCell().getX(), 7),
                    new Cell(move.getEndCell().getX(), 5)
            );
        }//long castle 0-0-0
        else {
            casMove = new Move(
                    new Cell(move.getEndCell().getX(), 0),
                    new Cell(move.getEndCell().getX(), 3)
            );
        }
        Board.getBoard().setPieceInBoard(casMove);
    }
}
