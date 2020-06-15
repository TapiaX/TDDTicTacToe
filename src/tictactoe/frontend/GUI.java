package tictactoe.frontend;

import tictactoe.backend.ITicTacToe;
import tictactoe.backend.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private char player;
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
		menu.add(reset = new JMenuItem("Reset"));
		reset.setMnemonic('R');

	}
	public void setFrame(JFrame frame){
		frame.addMouseListener(this);
		frame.add(bar,BorderLayout.SOUTH);
		frame.setJMenuBar(menuBar);
	}
	private void paintBoard(){
		paint(this.getGraphics());
	}
	public void paint(Graphics g){

		u = Math.min(getHeight(),getWidth())/3;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, u*3,u*3);
		g.setColor(Color.WHITE);
		for(int i=0;i<=u*3;i+=u){
			g.drawLine(0,i,u*3,i);
			g.drawLine(i,0,i,u*3);
		}
		for(CellValue c : marked){
			paintCell(c,g);
		}
		//repaint();
	}

	private void paintCell(CellValue c, Graphics g)
	{	if(g==null)
			g = this.getGraphics();
		if(c.m>0){
			if(c.m=='X')
			{	g.setColor(Color.red);
				g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15*u/10));
				g.drawString("x",c.j*u,(c.i)*u+u*4/5);
				//g.drawOval(c.j*u,c.i*u,u,u);	

				
				
			}
			else if(c.m=='O')
			{	g.setColor(Color.blue);
				g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15*u/10));
				g.drawString("o",c.j*u,(c.i)*u+u*4/5);
				//g.drawOval(c.j*u,c.i*u,u,u);	
			}
		}
		
	}
	private void paintString(Object... ms){
		u = Math.min(getHeight(),getWidth())/3;
		Graphics g = getGraphics();
		String res = "";
		for(Object m:ms)
			res += m.toString();
		g.setColor(Color.WHITE);
		g.setFont(Font.getFont("courier").deriveFont(Font.BOLD,u/res.length()/3-u/3));
		g.drawString(res,u/3,(int)(u*1.5));
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
		
		if(e.getSource()!=reset)
		{	int i =(e.getY()-55)/u;
			int j = e.getX()/u;

			if(tres.checkTicTacToe()|| tres.draw()) {
				marked = new LinkedList<CellValue>();
				paintBoard();
			}
			player = player=='X' ? 'O': 'X';
			if(tres.markMove(i,j))
			{
				marked.add(new CellValue(i,j,tres.getBoard()[i][j]));
				bar.setText(marked.getLast().toString());//+"\t"+e.getY());
				paintCell(marked.getLast(),null);
			}
			/*if(tres.checkTicTacToe()){
				paintString(tres.winner()," WINS");
			}*/
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset)
		{	tres = new TicTacToe();
			marked = new LinkedList<CellValue>();
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
			return "["+ (i*3+j+1) +"]= "+m;
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
