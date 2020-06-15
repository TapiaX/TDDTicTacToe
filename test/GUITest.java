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
    private Robot robot;
    private JFrame frame;
    @Before
    public void init() throws java.awt.AWTException{
        ITicTacToe game = new TicTacToe();
        gui =  new GUI(game);
        gui.run();
        frame = gui.getFrame();
        robot = new Robot();

    }
    @Test
    public  void presionarUnaCeldaCambia(){
        int u = gui.getU();
        int x1= frame.getX()+100;
        int y1=frame.getY()+100;
        Dimension frameDimension = frame.getSize();
        BufferedImage ss1 = robot.createScreenCapture(new Rectangle(frameDimension));
        robot.mouseMove(x1,y1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        BufferedImage ss2 = robot.createScreenCapture(new Rectangle(frameDimension));
        assertNotEquals(ss1,ss2);
    }

}