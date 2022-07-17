package models.pieces;

import models.enums.Color;
import validation.BishopValidator;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color, new BishopValidator());
    }
}
