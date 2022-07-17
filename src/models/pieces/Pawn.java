package models.pieces;

import models.enums.Color;
import validation.PawnValidator;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(color,new PawnValidator());
    }
}
