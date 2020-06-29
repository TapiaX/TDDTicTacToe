package tictactoe.frontend;

import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;
import tictactoe.frontend.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class GUITest {
    private GUI gui;

    @Before
    public void init(){
        ITicTacToe game = new TicTacToe();
        gui =  new GUI(game);
    }
    @Test
    public void getUNotZero()
    {   gui.run();
        assertNotEquals(0,gui.getU());

    }
    @Test
    public void getCoordinateYRow1()
    {   gui.run();
        assertEquals(1,gui.getCoordinateY(300));
    }
    @Test
    public  void presionarUnaCeldaCambia() throws java.awt.AWTException{
        gui.run();
        JFrame frame = gui.getFrame();
        Robot robot = new Robot();
        int u = gui.getU();
        int x1= frame.getX()+100;
        int y1= frame.getY()+100;
        Dimension frameDimension = frame.getSize();
        BufferedImage ss1 = robot.createScreenCapture(new Rectangle(frameDimension));
        robot.mouseMove(x1,y1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1000,900);
        BufferedImage ss2 = robot.createScreenCapture(new Rectangle(frameDimension));
        assertFalse(ss1.equals(ss2));
    }

}