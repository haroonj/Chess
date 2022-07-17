package com.company;
import game.ChessGame;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ChessGame game = new ChessGame("Fahed","Ahmad");
        while (!game.isDone()){
            String move = scanner.nextLine();
            if (game.isWhiteTurn())
                game.playWhite(move);
            else
                game.playBlack(move);
        }
        game.print();
        game.printWinnerName();
    }
}
