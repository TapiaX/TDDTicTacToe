package tictactoe.frontend;

import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GUI extends JPanel implements ITicTacToeUI,MouseListener,ActionListener
{	
	private ITicTacToe tres;
	private int u;
	private JMenuBar menuBar;
	private JButton reset,exit;
	private JLabel bar;
	private JFrame frame;
	private String message;

	public GUI(ITicTacToe tres)
	{	super();
		if(tres==null)
			tres =  new TicTacToe();
		this.tres = tres;
		this.setBackground(Color.DARK_GRAY);
		bar = new JLabel("Starting");
		menuBar = new JMenuBar();
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setMnemonic('R');
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setMnemonic('X');
		menuBar.add(exit);
		message = "";
		tres.addListener(this);
	}

	int getU(int height, int width){
		u = Math.min(height,width)/3;
		if(u==0) throw new ArithmeticException("U cannot be zero");
		return u;
	}

	void setFrame(JFrame frame){
		this.frame = frame;
		this.addMouseListener(this);
		frame.add(bar,BorderLayout.SOUTH);
		frame.setJMenuBar(menuBar);
	}

	public void paint(Graphics g){
		Rectangle b = frame.getBounds();
		frame.setBounds(b.x,b.y,b.height*25/28,b.height);
		try {
			getU(getHeight(),getWidth());
		} catch (ArithmeticException a){
			u = 100;
			frame.setBounds(b.x,b.y,410,450);
		}
		g.setColor(getBackground());
		g.fillRect(0, 0, u*3,u*3);
		g.setColor(Color.WHITE);
		for(int i=0;i<=u*3;i+=u){
			g.drawLine(0,i,u*3,i);
			g.drawLine(i,0,i,u*3);
		}
		char tab[][] = tres.getBoard();
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				paintCell(i,j,tab[i][j], g);
			}
		}
		paintString(g);
	}

	private void paintCell(int i, int j,int m, Graphics g)
	{	if(g==null)
			g = this.getGraphics();
		if(m>0){
			g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15*u/10));
			if(m=='X')
			{	g.setColor(Color.red);
				g.drawString("x",j*u,(i)*u+u*4/5);
				//g.drawOval(c.j*u,c.i*u,u,u);
			}
			else if(m=='O')
			{	g.setColor(Color.blue);
				g.drawString("o",j*u,(i)*u+u*4/5);
				//g.drawOval(c.j*u,c.i*u,u,u);	
			}
		}
	}

	private void paintString(Graphics g,Object... ms){
		if(g==null)
			g = getGraphics();
		for(Object m:ms)
			message += m.toString();
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD, u/2));
		g.drawString(message,2*u/3,(int)(u*1.5));
	}

	int getCoordinateOverU(int distance){
		return distance/u;
	}

	private void actualizeMessage(){
		message = "";
		if(tres.checkTicTacToe()){
			paintString(null,tres.winner()," WINS");
			menuBar.add(reset);
		}
		else if(tres.draw()){

			paintString(null,"DRAW");
			menuBar.add(reset);
		}
		else
			menuBar.remove(reset);
		//repaint();
		frame.setSize(frame.getWidth()+10,frame.getHeight());
		frame.repaint();

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		setBackground(Color.BLACK);
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		setBackground(Color.DARK_GRAY);
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int i = getCoordinateOverU(e.getY());
		int j = getCoordinateOverU(e.getX());
		if(tres.markMove(i,j))
		{	bar.setText("Cell marked ["+ i +"]["+ j +"]");

		}

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset)
		{	restart();
			bar.setText("Reset");
		}
		else if (e.getSource()==exit){
			close();
		}
	}

	private void restart(){
		tres.create();
		bar.setText("Starting new game");
		message = "";
		repaint();
	}

	private void close(){
		frame.setVisible(false);
		//frame.removeAll();
	}

	public void run() {
		JFrame frame = new JFrame("TicTacToe GUI");
		setFrame(frame);
		frame.add(this);
		frame.setSize(500,560);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	@Override
	public void update() {
		actualizeMessage();
	}
}
