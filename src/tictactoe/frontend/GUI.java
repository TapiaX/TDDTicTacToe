package tictactoe.frontend;

import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class GUI extends JPanel implements ITicTacToeUI,MouseListener, ActionListener
{	

	private ITicTacToe tres;
	private int u;
	private LinkedList<CellValue> marked;
	private JMenuBar menuBar;
	private JMenuItem reset;
	private JLabel bar;
	private JFrame frame;
	private char player;
	private String message;

	public GUI(ITicTacToe tres)
	{	super();
		player = 'X';
		if(tres==null)
			tres =  new TicTacToe();
		this.tres = tres;


		this.setBackground(Color.BLACK);
		marked = new LinkedList<CellValue>();
		bar = new JLabel("Starting");
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		menu.setMnemonic('G');
		menuBar.add(menu);
		reset = new JMenuItem("Reset");
		reset.addActionListener(this);
		reset.setMnemonic('R');
		menu.add(reset);
		message = "";

	}
	public int getU(){return u;}
	public void setFrame(JFrame frame){
		this.frame = frame;
		frame.addMouseListener(this);
		frame.add(bar,BorderLayout.SOUTH);
		frame.setJMenuBar(menuBar);
	}
	public JFrame getFrame(){ return frame;}
	private void paintBoard(){
		paint(this.getGraphics());
	}
	public void paint(Graphics g){
		Rectangle b = frame.getBounds();
		frame.setBounds(b.x,b.y,b.height*25/28,b.height);
		u = Math.min(getHeight(),getWidth())/3;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, u*3,u*3);
		g.setColor(Color.WHITE);
		for(int i=0;i<=u*3;i+=u){
			g.drawLine(0,i,u*3,i);
			g.drawLine(i,0,i,u*3);
		}
		/*for(CellValue c : marked){
			paintCell(c,g);
		}*/
		char tab[][] = tres.getBoard();
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				paintCell(i,j,tab[i][j], g);
			}
		}

		paintString(g);
		//repaint();
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
		//u = Math.min(getHeight(),getWidth())/3;
		if(g==null)
			g = getGraphics();
		for(Object m:ms)
			message += m.toString();
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD, u/2));
		g.drawString(message,2*u/3,(int)(u*1.5));
	}
	public int getCoordinateY(int y){
		return (y-55)/u;
	}
	public int getCoordinateX(int x){
		return x/u;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int i = getCoordinateY(e.getY());
		int j = getCoordinateX(e.getX());
		if(tres.checkTicTacToe()|| tres.draw()) {
			boolean newG = JOptionPane.YES_OPTION==JOptionPane.showInternalConfirmDialog(null,
					                                                                     "Start a new game?",
					                                                                     "Question for new game",
					                                                                      JOptionPane.YES_NO_OPTION);
			if(newG) {
				tres.create();
				marked.clear();
				message = "";
				repaint();
			} else {
				frame.setVisible(false);
				frame.dispose();
			}
		}

		else if(tres.markMove(i,j))
		{	player = tres.getBoard()[i][j];
			marked.add(new CellValue(i,j,player));
			bar.setText("Cell marked "+marked.getLast());
			repaint();
		}
		if(tres.checkTicTacToe()){
			paintString(null,tres.winner()," WINS");
		}
		if(tres.draw()){
			paintString(null,tres.winner(),"DRAW");
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset)
		{
			tres.create();
			marked.clear();
			message = "";
			repaint();
			bar.setText("Reset");
		}
	}
	private class CellValue{
		int i,j;
		char m;
		public CellValue(int i,int j,char m)
		{	this.i = i;
			this.j = j;
			this.m = m;
		}
		@Override
		public String toString(){
			return "["+ i +"]["+ j +"] with "+ String.valueOf(m);
		}
	}
	public void run() {
		JFrame frame = new JFrame("backend.TicTacToe");
		setFrame(frame);
		frame.add(this);
		frame.setSize(500,560);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
