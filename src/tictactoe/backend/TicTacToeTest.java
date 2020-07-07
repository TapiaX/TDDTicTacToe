package tictactoe.backend;

import org.junit.Test;
import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;

import java.util.Arrays;

import static org.junit.Assert.*;

class TicTacToeTest {

    @Test
    public void markMoveFreeXTest() {
        ITicTacToe tres = new TicTacToe();
        assertTrue(tres.markMove(0,0 ));
    }

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


    public void checkTicTacToeAfterRestartFalseTest() {
        ITicTacToe tres = new TicTacToe();
        tres.markMove(0,1);
        tres.markMove(1,0);
        tres.markMove(1,1);
        tres.markMove(2,0);
        tres.markMove(2,1);
        tres.create();
        tres.markMove(1,2);
        assertFalse(tres.checkTicTacToe());
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
    public void drawWith2CellsMarkedFalseTest(){
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

