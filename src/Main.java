public class Main {
    public static void main(String args[]){
        ITicTacToe game = new TicTacToe();
        Console console = new Console(game);
        console.run();
    }
}
