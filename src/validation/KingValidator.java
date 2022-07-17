package validation;

import movement.Move;

public class KingValidator implements IValidator {
    @Override
    public boolean isValidMove(Move move) {
        return true;
    }
}
