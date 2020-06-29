import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;
import tictactoe.frontend.ITicTacToeUI;
import tictactoe.frontend.GUI;
import tictactoe.frontend.Console;

public class Main {
    public static void main(String args[]){
        ITicTacToe game = new TicTacToe();
        ITicTacToeUI console = new Console(game);
        ITicTacToeUI gui = new GUI(game);
        gui.run();
        console.run();
    }
}
