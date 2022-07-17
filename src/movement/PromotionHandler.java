package movement;

import game.Board;
import models.pieces.Piece;
import models.pieces.Queen;

public class PromotionHandler extends MovementHandler {
    @Override
    public void handle(Move move) {
        Piece piece = Board.getBoard().getPiece(
                move.getStartCell().getX(),
                move.getStartCell().getY()
        );

        if(
                piece != null
                && piece.toString().equals("Pawn")
                && (move.getEndCell().getX()==0 || move.getEndCell().getX()==7 )
        ){
            Board.getBoard().setPieceInBoard(move);
            Piece queen = new Queen(piece.getColor());
            Board.getBoard().setPiece(
                    move.getEndCell().getX(),
                    move.getEndCell().getY(),
                    queen
                    );
            return;
        }
        if(nextHandler!=null)
            nextHandler.handle(move);
        else
            System.out.println("Request cannot be handled");
    }
}
