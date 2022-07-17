package validation;

import movement.Move;

public class PawnValidator implements IValidator{
    @Override
    public boolean isValidMove(Move move) {
        return true;
    }
}
