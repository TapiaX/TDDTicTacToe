package tictactoe.frontend;

import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;

import java.util.Scanner;

public class Console implements ITicTacToeUI{
    public ITicTacToe tres;
    Console(){
        //do nothing
    }
    public Console(ITicTacToe t){
        addTicTacToe(t);
    }
    ITicTacToe addTicTacToe(ITicTacToe t){
        if(tres==null)
            tres = new TicTacToe();
        tres = t;
        return tres;
    }
    int getNumber(String i){
        return Integer.parseInt(i);
    }

    private String stringBoard() {
        String res="";
        char[][] board= tres.getBoard();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                res += "[";
                res += board[i][j]==0 ? "_" : String.valueOf(board[i][j]);
                res += "]";
            }
            res+="\n";
        }
        return res;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        //char actualPlayer='X';
        int row,column,errors = 0;
        boolean quit=false,error;
        addTicTacToe(tres);
        do{
            System.out.println("New Game of TicTacToe");
            do {
                //actualPlayer = tres.getMark();

                System.out.println("Is time for next player");
                System.out.println("#row:");
                error=false;
                try{
                    row = getNumber(sc.next());
                    System.out.println("#column:");
                    column = getNumber(sc.next());
                    error = !tres.markMove(row,column);
                }catch (NumberFormatException ne){
                    error=true;
                }
                if (!error) {
                    System.out.print(stringBoard());
                    //actualPlayer = actualPlayer =='X' ? 'O' : 'X';
                }else
                    errors += 1;
            }while (!tres.checkTicTacToe()&&!tres.draw());
            int d = 0;
            if (tres.checkTicTacToe()) {
                System.out.println("<<" + String.valueOf(tres.winner()) + " WINS>>");
            }
            else if(tres.draw())
                System.out.println("GAME TIE");
            System.out.println("New Game (any input); Quit (\"Q\")");
            quit = sc.next().matches("^[qQ]$");
            if(!quit) tres.create();
        }while(!quit);
        System.out.println(errors+ " errors in key input.");
    }
}
