package tictactoe.backend;

import tictactoe.frontend.ITicTacToeUI;

public interface IObservable {
    public void addListener(ITicTacToeUI observer);
}
