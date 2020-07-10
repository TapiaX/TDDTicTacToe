package tictactoe.frontend;

import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;

import static org.junit.Assert.*;

//public //for testing only
class GUITest {
    private GUI gui;

    @Before
    public void init(){
        ITicTacToe game = new TicTacToe();
        gui =  new GUI(game);
    }
    @Test
    public void getUNotZero()
    {   assertNotEquals(0,gui.getU(500,600));

    }
    @Test (expected = ArithmeticException.class)
    public void getUZero()
    {   gui.getU(0,0);
    }
    @Test
    public void getCoordinateOverURow1()
    {   gui.getU(500,600);
        assertEquals(1,gui.getCoordinateOverU(300));
    }

}