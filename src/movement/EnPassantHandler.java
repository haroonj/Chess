package movement;

import game.Board;
import models.enums.Color;
import models.pieces.Piece;

public class EnPassantHandler extends MovementHandler {
    @Override
    public void handle(Move move) {
        Piece piece = Board.getBoard().getPiece(
                move.getStartCell().getX(),
                move.getStartCell().getY()
        );
        Move lastMove = Board.getBoard().getLastMove();
        if(
                piece != null
                && lastMove !=null
                && piece.toString().equals("Pawn")
                && lastMove.getEndCell().getPiece().toString().equals("Pawn")
                && lastMove.absHorizontalDifferance() ==2
        ){
            if (
                    piece.getColor()== Color.White
                    && move.getEndCell().getY() == lastMove.getEndCell().getY()
                    && move.getEndCell().getX() ==lastMove.getEndCell().getX()+1
            ){
                enPassant(move,lastMove);
                return;
            }
            if (
                    piece.getColor()== Color.Black
                    && move.getEndCell().getY() == lastMove.getEndCell().getY()
                    && move.getEndCell().getX() ==lastMove.getEndCell().getX()-1
            ){
                enPassant(move,lastMove);
                return;
            }
        }
        if(nextHandler!=null)
            nextHandler.handle(move);
        else
            System.out.println("Request cannot be handled");
    }
    private void enPassant(Move move,Move lastMove){
        Board.getBoard().setPieceInBoard(move);
        Board.getBoard().killPiece(
                lastMove.getEndCell().getX(),
                lastMove.getEndCell().getY()
        );
    }
}
