package models.pieces;

import models.enums.Color;
import validation.KingValidator;

public class King extends Piece {
    private boolean canCastle;
    public King(Color color){
        super(color,new KingValidator());
        canCastle=true;
    }
    public void disableCastling(){
        canCastle=false;
    }
    public boolean canCastling(){
        return canCastle;
    }
}
