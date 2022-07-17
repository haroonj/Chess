package validation;

import movement.Move;

public class RookValidator implements IValidator{
    @Override
    public boolean isValidMove(Move move) {
        return true;
    }
}
