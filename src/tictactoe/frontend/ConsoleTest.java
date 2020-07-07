package tictactoe.frontend;

import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;
import tictactoe.frontend.Console;

import static org.junit.Assert.*;


public class ConsoleTest {
    private Console console;
    private ITicTacToe tres;
    @Before
    public void init(){
        tres = new TicTacToe();
        console =  new Console(tres);
    }
    @Test
    public void addTicTacToeSameObject(){
        assertSame(tres,console.addTicTacToe(tres));
    }

    @Test
    public void getNumberNumberValidTest()
    {   assertEquals(3,console.getNumber("3"));
    }

    @Test(expected = NumberFormatException.class)
    public void getNumberInvalidTest()
    {
        console.getNumber("dvsa");
    }
}