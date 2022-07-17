package movement;

public interface IMovementHandler {
     void setNextHandler(IMovementHandler handler);
     void handle(Move move);
}
