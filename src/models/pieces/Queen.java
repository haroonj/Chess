package models.pieces;

import models.enums.Color;
import validation.QueenValidator;

public class Queen extends Piece{

    public Queen(Color color) {
        super(color, new QueenValidator());
    }
}
