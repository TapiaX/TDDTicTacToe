package tictactoe.backend;

public class TicTacToe implements ITicTacToe {
    private char cells[][];
    private int remaining = 9;
    private boolean someoneWins;
    private boolean xStarts;
    public TicTacToe(){
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
    }
    private int getRemaining(){
        return remaining;
    }
    @Override
    public boolean markMove(int row, int column){
        if(someoneWins || remaining==0) create();//llamada interna
        boolean existedAndFree = existsAndFree(row, column);
        if(existedAndFree) {
            cells[row][column] = getMark();
            remaining--;
            if(remaining<=4) someoneWins = checkWinner(row,column);
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
        return !checkTicTacToe() && getRemaining()==0;
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
}