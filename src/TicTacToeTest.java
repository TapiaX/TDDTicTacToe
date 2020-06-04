import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TicTacToeTest {

    /*@Test
    public void getRemainingCreatedTest() {
        ITicTacToe tres = new TicTacToe();
        assertEquals(9, tres.getRemaining());
    }*/

    @Test
    public void markMoveFreeXTest() {
        ITicTacToe tres = new TicTacToe();
        assertTrue(tres.markMove(0,0 ));
    }
    /*
    @Test
    public void getRemaining1MarkedTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        assertEquals(8, tres.getRemaining());
    }*/

    @Test
    public void markMoveNotExistsTest() {
        ITicTacToe tres = new TicTacToe();
        assertFalse(tres.markMove(100,0));
    }

    @Test
    public void markMoveOcupedTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,0);
        tres.markMove(0,1);
        assertFalse(tres.markMove(0,0));
    }
    /*
    @Test
    public void getRemaining1NotMarkedTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        int faltan = tres.getRemaining();
        tres.markMove(0,1);
        assertEquals(faltan, tres.getRemaining());
    }*/

    @Test
    public void getCellMarkedXTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        assertEquals('X', tres.getBoard()[0][1]);
    }

    @Test
    public void getCellMarkedOTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        tres.markMove(2,0);
        assertEquals('O', tres.getBoard()[2][0]);
    }
    @Test
    public void getCellNotMarkedTest(){
        ITicTacToe tres = new TicTacToe();
        assertEquals(0, tres.getBoard()[0][0]);
    }

    @Test
    public void checkTicTacToeXWinsTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        tres.markMove(2,0);
        tres.markMove(2,1);
        assertTrue(tres.checkTicTacToe());
    }

    @Test
    public void checkTicTacToePlayingTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        tres.markMove(2,0);
        assertFalse(tres.checkTicTacToe());
    }

    @Test
    public void checkTicTacToe2TimesTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        tres.markMove(2,0);
        tres.markMove(2,1);
        boolean gano = tres.checkTicTacToe();
        tres.markMove(1,2);
        assertNotEquals(gano, tres.checkTicTacToe());
    }

    @Test
    public void checkTicTacToeOWinsTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        tres.markMove(2,0);
        tres.markMove(0,2);
        tres.markMove(0,0);
        assertTrue(tres.checkTicTacToe());
    }

    @Test
    public void checkTicTacToeOWinsDiagTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,0);
        tres.markMove(1,1);
        tres.markMove(1,0);
        tres.markMove(2,0);
        tres.markMove(0,1);
        tres.markMove(0,2);
        assertTrue(tres.checkTicTacToe());
    }

    @Test
    public void checkTicTacToeXWinsDiagTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(1,1);
        tres.markMove(1,0);
        tres.markMove(2,0);
        tres.markMove(0,1);
        tres.markMove(0,2);
        assertTrue(tres.checkTicTacToe());
    }

    @Test
    public void checkTicTacToeTieTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        assertFalse(tres.checkTicTacToe());

    }
    /*
    @Test
    public void getRemainingTieTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        assertEquals(0, tres.getRemaining());
    }*/
    /*
    @Test
    public void getRemainingTieFor2TimesTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        int remaining = tres.getRemaining();
        tres.markMove(0,1);
        assertNotEquals(remaining, tres.getRemaining());
    }
    */
    @Test
    public void getCell2doJuegoTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        //inicia nuevo juego
        tres.markMove(0,1);
        assertNotEquals('X', tres.getBoard()[0][1]);
    }
    /*
    @Test
    public void getMarkXTest() {
        ITicTacToe tres = new TicTacToe();
        assertEquals('X', tres.getMark());
    }*/

    /*@Test
    public void getMarkOTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,2);
        assertEquals('O', tres.getMark());
    }*/

    @Test
    public void winnerXWinsTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(1,1);
        tres.markMove(1,0);
        tres.markMove(2,0);
        tres.markMove(0,1);
        tres.markMove(0,2);
        assertEquals('X', tres.winner());
    }

    @Test
    public void winnerOWinsDiagonalTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,0);
        tres.markMove(1,1);
        tres.markMove(1,0);
        tres.markMove(2,0);
        tres.markMove(0,1);
        tres.markMove(0,2);
        assertEquals('O', tres.winner());
    }
    @Test
    public void winnerTieTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        assertEquals(0, tres.winner());
    }
    /*
    @Test
    public void continues2CellsMarkedTest(){
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,1);
        assertTrue(tres.continues());
    }*/
    /*
    @Test
    public void continuesTieTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        assertFalse(tres.continues());
    }*/
    /*@Test
    public void continuesOWinsDiagonalTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,0);
        tres.markMove(1,1);
        tres.markMove(1,0);
        tres.markMove(2,0);
        tres.markMove(0,1);
        tres.markMove(0,2);
        assertFalse(tres.continues());
    }*/

    @Test
    public void drawIsATieTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(0,2);
        tres.markMove(1,1);
        tres.markMove(2,1);
        tres.markMove(0,0);
        tres.markMove(2,2);
        tres.markMove(2,0);
        tres.markMove(1,0);
        tres.markMove(1,2);
        assertTrue(tres.draw());
    }
    @Test
    public void drawXWinsTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(1,1);
        tres.markMove(1,0);
        tres.markMove(2,0);
        tres.markMove(0,1);
        tres.markMove(0,2);
        assertFalse(tres.draw());
    }
    @Test
    public void draw2CellsMarkedTest(){
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,1);
        assertFalse(tres.draw());
    }

    @Test
    public void getBoardEmpty(){
        ITicTacToe tres = new TicTacToe();
        char [] [] boardExpected = {{0,0,0},{0,0,0},{0,0,0}};
        assertTrue(Arrays.deepEquals(boardExpected,tres.getBoard()));
    }

    @Test
    public void getBoardSomeMarkedCells(){
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(2,0);
        char [] [] boardExpected = {{0,'X',0},{0,0,0},{'O',0,0}};
        assertTrue(Arrays.deepEquals(boardExpected,tres.getBoard()));
    }


}

