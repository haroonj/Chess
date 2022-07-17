package movement;

public abstract class MovementHandler implements IMovementHandler{
    protected IMovementHandler nextHandler = null;
    @Override
    public void setNextHandler(IMovementHandler handler) {
        if(handler==null)
            throw new IllegalArgumentException();
        this.nextHandler=handler;
    }
    @Override
    public abstract void handle(Move move);
}
