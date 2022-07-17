package game;

import models.enums.*;
import movement.*;

public class ChessGame {
    private final String firstPlayer;
    private final String secondPlayer;
    private GameStatus status;
    private boolean whiteTurn;
    private final IMovementHandler movementHandler;

    public ChessGame(String firstPlayer,String secondPlayer){
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
        status = GameStatus.ACTIVE;
        whiteTurn=true;

        IMovementHandler regularMovementHandler = new RegularMovementHandler();
        IMovementHandler castlingHandler = new CastlingHandler();
        IMovementHandler promotionHandler = new PromotionHandler();
        IMovementHandler enPassantHandler = new EnPassantHandler();

        enPassantHandler.setNextHandler(promotionHandler);
        promotionHandler.setNextHandler(castlingHandler);
        castlingHandler.setNextHandler(regularMovementHandler);

        movementHandler =enPassantHandler;
    }

    public boolean isDone(){
        return status != GameStatus.ACTIVE;
    }
    public boolean isWhiteTurn(){
        return whiteTurn;
    }
    public void playWhite(String moveInput){
        if(play(moveInput))
            whiteTurn =false;
    }
    public void playBlack(String moveInput){
        if(play(moveInput))
            whiteTurn =true;
    }
    public void printWinnerName(){
        if(status == GameStatus.WHITE_WIN)
            System.out.println(firstPlayer+" is the winner");
        else
            System.out.println(secondPlayer+" is the winner");
    }
    private boolean play(String moveInput){
        Move move =parseMove(moveInput);
        if(move!=null) {
            if(move.validateTheMove()) {
                movementHandler.handle(move);
                updateStatus();
                return true;
            }
            else
                System.out.println((whiteTurn?firstPlayer:secondPlayer) + " entered an illegal move, try again please");
        }
        else
            System.out.println((whiteTurn?firstPlayer:secondPlayer)  + " entered an illegal move format, try again please");

        return false;
    }
    private Move parseMove(String moveInput){
        moveInput=moveInput.toLowerCase();
        boolean validInput = moveInput.matches("move\\s[a-h][1-8]\\s[a-h][1-8]");
        Move move;
        if(validInput){
            String[] tmp = moveInput.replaceAll("\\s+$", "").split(" ");
            move=new Move(
                    new Cell(tmp[1].charAt(1)-49,tmp[1].charAt(0)-97),
                    new Cell(tmp[2].charAt(1)-49,tmp[2].charAt(0)-97)
            );
            return move;
        }
        return null;
    }
    private void updateStatus(){
        if(Board.getBoard().stallMate())
            status = GameStatus.STALEMATE;
        else if(Board.getBoard().checkMate()) {
            if(Board.getBoard().getWinnerColor()==Color.White)
                status = GameStatus.WHITE_WIN;
            else
                status = GameStatus.BLACK_WIN;
        }
        else
            status = GameStatus.ACTIVE;
    }
    public void print(){Board.getBoard().print();}
}
