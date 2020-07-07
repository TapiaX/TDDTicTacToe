package tictactoe.backend;

public interface ITicTacToe extends Observable{
    public void create();
    public boolean markMove(int row,int column);
    public boolean checkTicTacToe();
    public char winner();
    public char[][] getBoard();
    //public boolean continues();
    public boolean draw();
    //public char getMark();
}
