package tictactoe.frontend;

import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;
import java.util.Scanner;

public class Console implements ITicTacToeUI{

    private ITicTacToe tres;
    Console(){
        //does nothing
    }
    public Console(ITicTacToe t){
        addTicTacToe(t);
        tres.addListener(this);
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
        int row=0,column=0,errors = 0;
        boolean quit=false,error;
        addTicTacToe(tres);
        String input = "";
        System.out.println("Is time for next player");
        System.out.println("#row:");
        do{ error=false;
            try{
                input = sc.next();
                if((tres.draw()||tres.checkTicTacToe())){
                    quit = input.matches("^[qQ]$");
                    if(!quit) {
                        System.out.println("New Game of TicTacToe");
                        tres.create();
                        input = sc.next();
                    }
                }
                row = getNumber(input);
                System.out.println("#column:");
                input = sc.next();
                column = getNumber(input);
                error = !tres.markMove(row,column);
            }catch (NumberFormatException ne){
                error=true;
            }
            if (error) {
                System.out.println("#row:");
                errors += 1;
            }
        }while(!quit);
        System.out.println(errors+ " errors in key input.");
    }

    @Override
    public void update() {
        boolean finished = false;
        System.out.println(stringBoard());
        if (tres.checkTicTacToe()) {
            System.out.println("<<" + String.valueOf(tres.winner()) + " WINS>>");
            finished = true;
        }
        else if(tres.draw()) {
            System.out.println("GAME TIE");
            finished = true;
        }

        if(finished)
            System.out.println("New Game (any input); Quit (\"Q\")");
        else{
            System.out.println("Is time for next player");
            System.out.println("#row:");
        }
    }
}
