package game;

import models.enums.Color;
import models.pieces.*;
import movement.Move;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private static Board board =null;
    private final List<Piece> killedPieces;
    private final Cell[][] chessCells;
    private boolean kingKilled = false;
    private Color winnerColor;
    private Move lastMove=null;

    private Board(){
        chessCells = new Cell[8][8];
        killedPieces = new LinkedList<>();
        resetBoard();
    }
    public static Board getBoard() {
        if(board==null)
            board= new Board();
        return board;
    }
    public void setPieceInBoard(Move move){
        int x= move.getEndCell().getX();
        int y = move.getEndCell().getY();
        if(chessCells[x][y].getPiece() != null)
            killPiece(x,y);
        Piece piece = getPiece(
                move.getStartCell().getX(),
                move.getStartCell().getY()
        );

        chessCells[x][y].setPiece(piece);
        removePiece(
                move.getStartCell().getX(),
                move.getStartCell().getY()
        );
        move.setEndCell(new Cell(x,y,piece));
        lastMove = move;
    }
    public void killPiece(int x,int y){
        chessCells[x][y].killPiece();
        killedPieces.add(chessCells[x][y].getPiece());

        if(chessCells[x][y].getPiece()!=null &&chessCells[x][y].getPiece().toString().equals("King")) {
            kingKilled = true;
            if(chessCells[x][y].getPiece().getColor()==Color.White)
                winnerColor=Color.Black;
            else
                winnerColor=Color.White;
        }
        removePiece(x,y);
    }
    private void removePiece(int x, int y){
        chessCells[x][y].setPiece(null);
    }
    public Piece getPiece(int x, int y){
        return  chessCells[x][y].getPiece();
    }
    public void setPiece(int x,int y,Piece piece){
        chessCells[x][y].setPiece(piece);
    }
    public Color getWinnerColor(){
        return winnerColor;
    }
    public Move getLastMove(){
        return lastMove;
    }
    public boolean canCastle(Piece piece){
        if(piece.toString().equals("King"))
        {
            King king = (King) piece;
            return king.canCastling();
        }
        return false;
    }
    public void disableCastling(Piece piece){
        if(piece.toString().equals("King"))
        {
            King king = (King) piece;
            king.disableCastling();
        }
    }
    public boolean kingIsUnderAttack(){return false;}
    public boolean stallMate(){
        return false;
    }
    public boolean checkMate(){
        return kingKilled;
    }
    public void resetBoard(){
        chessCells[0][0] =new Cell(0,0,new Rook(Color.White));
        chessCells[0][1] =new Cell(0,1,new Knight(Color.White));
        chessCells[0][2] =new Cell(0,2,new Bishop(Color.White));
        chessCells[0][3] =new Cell(0,3,new Queen(Color.White));
        chessCells[0][4] =new Cell(0,4,new King(Color.White));
        chessCells[0][5] =new Cell(0,5,new Bishop(Color.White));
        chessCells[0][6] =new Cell(0,6,new Knight(Color.White));
        chessCells[0][7] =new Cell(0,7,new Rook(Color.White));
        for(int i=0;i<8;i++)
            chessCells[1][i] =new Cell(1,i,new Pawn(Color.White));

        chessCells[7][0] =new Cell(7,0,new Rook(Color.Black));
        chessCells[7][1] =new Cell(7,1,new Knight(Color.Black));
        chessCells[7][2] =new Cell(7,2,new Bishop(Color.Black));
        chessCells[7][3] =new Cell(7,3,new Queen(Color.Black));
        chessCells[7][4] =new Cell(7,4,new King(Color.Black));
        chessCells[7][5] =new Cell(7,5,new Bishop(Color.Black));
        chessCells[7][6] =new Cell(7,6,new Knight(Color.Black));
        chessCells[7][7] =new Cell(7,7,new Rook(Color.Black));
        for(int i=0;i<8;i++)
            chessCells[6][i] =new Cell(6,i,new Pawn(Color.Black));

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                chessCells[i][j] = new Cell(i, j, null);
            }
        }

        killedPieces.clear();
    }
    public void print(){
        System.out.println();
        for(int i =7;i>=0;i--) {
            for (int j =0;j<8;j++) {
                Cell s0 = chessCells[i][j];
                System.out.printf("%-15s", s0.getPiece() == null ? " " + s0 : s0.getPiece().getColor().toString() + s0);
            }
            System.out.println();
        }
        System.out.println(killedPieces);

    }


}
