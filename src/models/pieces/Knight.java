package models.pieces;

import models.enums.Color;
import validation.KnightValidator;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color, new KnightValidator());
    }
}
