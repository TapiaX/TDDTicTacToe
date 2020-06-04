import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConsoleTest {
    private Console console;
    private ITicTacToe tres;
    @Before
    public void init(){
        tres = new TicTacToe();
        console =  new Console();
    }
    @Test
    public void startConsoleSameObject(){
        assertSame(tres,console.addTicTacToe(tres));
    }

    @Test
    public void getNumberNumberTest()
    {
        assertEquals(3,console.getNumber("3"));
    }

    @Test(expected = NumberFormatException.class)
    public void getNumberInvalidaTest()
    {
        console.getNumber("dvsa");
    }
}