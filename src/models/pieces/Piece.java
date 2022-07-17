package models.pieces;

import models.enums.Color;
import movement.Move;
import validation.IValidator;

public class Piece {

    private boolean killed;
    private final Color color;
    private IValidator validator;

    public Piece( Color color, IValidator validator) {
        this.killed = false;
        this.color = color;
        this.validator = validator;
    }
    public boolean isKilled(){
        return killed;
    }
    public void kill(){
        killed=true;
    }
    public Color getColor() {
        return color;
    }
    public boolean canMove(Move move){
        return validator.isValidMove(move);
    }
    public void setValidator(IValidator validator) {
        this.validator = validator;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
