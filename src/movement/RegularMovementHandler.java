package movement;

import game.Board;
import models.pieces.Piece;

public class RegularMovementHandler extends MovementHandler{
    @Override
    public void handle(Move move) {
        doMove(move);
    }
    private void doMove(Move move){
        Piece piece = Board.getBoard().getPiece(
                move.getStartCell().getX(),
                move.getStartCell().getY()
        );
        if(piece!=null && Board.getBoard().canCastle(piece))
            Board.getBoard().disableCastling(piece);

        Board.getBoard().setPieceInBoard(move);
    }

}
