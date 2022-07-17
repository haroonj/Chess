package validation;

import movement.Move;

public class BishopValidator implements IValidator{
    @Override
    public boolean isValidMove(Move move) {
        return true;
    }
}
