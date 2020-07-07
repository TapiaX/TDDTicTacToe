package tictactoe.backend;

public interface Observer {
    public void updateBoard(Observable subject);
    public void updateFinish(Observable subject);
}

