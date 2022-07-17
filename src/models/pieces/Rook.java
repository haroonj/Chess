package models.pieces;

import models.enums.Color;
import validation.RookValidator;

public class Rook extends Piece{
    public Rook(Color color) {
        super(color, new RookValidator());
    }

}
