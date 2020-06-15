import tictactoe.backend.*;
import tictactoe.frontend.*;

public class Main {
    public static void main(String args[]){
        ITicTacToe game = new TicTacToe();
        //ITicTacToeUI console = new Console(game);
        ITicTacToeUI gui = new GUI(game);
        //console.run();
        gui.run();
    }
}
