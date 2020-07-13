package tictactoe.backend;

import tictactoe.frontend.ITicTacToeUI;

public class TicTacToe implements ITicTacToe {
    private ChangeManager changeManager;
    private char cells[][];
    private int remaining = 9;
    private boolean someoneWins;
    private boolean xStarts;
    public TicTacToe()
    {   this.changeManager = ChangeManager.getInstance();
        cells = new char[3][3];
        create();
    }

    @Override
    public void create(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cells[i][j]=0;
            }
        }
        remaining = 9;
        someoneWins=false;
        xStarts=true;
        notifyObservers("create");
    }

    @Override
    public boolean markMove(int row, int column){
        if(someoneWins || remaining==0) create();//llamada interna
        boolean existedAndFree = existsAndFree(row, column);
        if(existedAndFree) {
            cells[row][column] = getMark();
            remaining--;
            notifyObservers("markMove");
            if(remaining<=4) someoneWins = checkWinner(row,column);
            if(checkTicTacToe()||draw()) notifyObservers("winner");
        }
        return existedAndFree&&!existsAndFree(row,column);
    }
    private boolean mark(int cell){
        cell--;
        return markMove(cell/3,cell%3);
    }
    private boolean existsAndFree(int row, int column)
    {   return row>=0&&row<3&&column>=0&&column<3&&cells[row][column]==0;
    }
    private char getCell(int row, int column){
        char value;
        value = cells[row][column];

        return value;
    }

    private char getMark(){
        return getMark(remaining);
    }
    private char getMark(int time){
        char mark;
        if(xStarts)
            mark = time%2>0 ? 'X':'O';
        else
            mark = time%2>0 ? 'O':'X';
        return mark;
    }
    @Override
    public char winner(){
        char winner= 0; //extra value
        if(checkTicTacToe())
            winner = getMark(remaining+1);
        return winner;
    }
    @Override
    public boolean checkTicTacToe()
    {   return someoneWins;
    }
    private boolean checkWinner(int row,int column) {
        boolean won=false;
        if(row==column)//main diagonal
        {   boolean diag=true;
            for(int i = 0;i<cells.length;i++) {
                diag = diag && cells[row][column] ==cells[i][i];
            }
            won=diag;
        }
        if(!won&&row+column==cells.length-1)//secundary diagonal
        {   boolean diag=true;
            for(int i = 0;i<cells.length;i++) {
                diag = diag && cells[row][column] ==cells[i][cells.length-1-i];
            }
            won=diag;
        }
        if(!won){
            boolean horiz = true;
            boolean vert = true;
            for(int i = 0;i<cells.length;i++){
                horiz= horiz && cells[row][column] == cells[row][i];
                vert = vert && cells[row][column] == cells[i][column];
            }
            won = horiz || vert;
        }
        return won;
    }

    @Override
    public boolean draw() {
        return !checkTicTacToe() && remaining==0;
    }
    @Override
    public char[][] getBoard(){
        char[][] tab = new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tab[i][j]= cells[i][j];
            }
        }
        return  tab;
    }


    @Override
    public void addListener(ITicTacToeUI observer) {
        changeManager.register(this,observer);
    }

    private void notifyObservers(String name){
        changeManager.notifyObservers(this,name);
    }
}