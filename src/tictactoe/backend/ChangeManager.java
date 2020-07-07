package tictactoe.backend;

public interface ChangeManager {
    void register(Observable Observable, Observer observer);

    void unregister(Observable Observable, Observer observer);

    void notifyBoard(Observable Observable);

    void notifyFinish(Observable Observable);
}
