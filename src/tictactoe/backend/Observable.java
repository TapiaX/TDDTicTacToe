package tictactoe.backend;

public interface Observable {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyBoard();
    public void notifyFinish();
}
