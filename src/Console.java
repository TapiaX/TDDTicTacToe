import java.util.Scanner;

public class Console {
    public ITicTacToe tres;
    public Console(){

    }
    public Console(ITicTacToe t){
        addTicTacToe(t);
    }
    public ITicTacToe addTicTacToe(ITicTacToe t){
        if(tres==null)
            tres = new TicTacToe();
        tres = t;
        return tres;
    }
    public int getNumber(String i){
        return Integer.parseInt(i);
    }

    public String printBoard() {
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

    public void run() {
        Scanner sc = new Scanner(System.in);
        char actualPlayer='X';
        int row,column,errors = 0;
        boolean quit=false,error;
        addTicTacToe(tres);
        do{
            System.out.println("New Game of TicTacToe");
            do {
                //actualPlayer = tres.getMark();

                System.out.println("Is time for " + String.valueOf(actualPlayer));
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
                    System.out.print(printBoard());
                    //edit
                    actualPlayer = actualPlayer =='X' ? 'O' : 'X';
                }else
                    errors += 1;
            }while (!tres.checkTicTacToe()&&!tres.draw());//(tres.continues());
            int d = 0;
            if (tres.checkTicTacToe()) {
                System.out.println("<<" + String.valueOf(tres.winner()) + " WINS>>");
            }
            else
                System.out.println("GAME TIE");
            System.out.println("New Game (any input); Quit (\"Q\")");
            quit = sc.next().matches("^[qQ]$");
        }while(!quit);
        System.out.println(errors+ " errors in key input.");
    }
}
