package tictactoe.backend;

import tictactoe.frontend.ITicTacToeUI;

public interface ITicTacToe{
    public void create();
    public boolean markMove(int row,int column);
    public boolean checkTicTacToe();
    public char winner();
    public boolean draw();
    public char[][] getBoard();
    public void addListener(ITicTacToeUI observer);
}
