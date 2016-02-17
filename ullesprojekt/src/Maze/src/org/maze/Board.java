package Maze.src.org.maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
	private Timer timer; //opretter en timer til actionlistener
	
	private Map map;
	private Player p;
	private Enemy en;
	private CircleEnemy ce;

	
	private boolean win = false;
//	private boolean gameover = false;
	
	private String Message = "";
	private String Message1 = "";
	
	private Font font = new Font("Serif",Font.BOLD, 48);
	
	public Board(){
		
		map = new Map();
		p = new Player();
		en = new Enemy();
		ce = new CircleEnemy();

		
		addKeyListener(new Al());
		setFocusable(true);
		
		timer = new Timer(25, this);
		timer.start();
		
	}
	public void actionPerformed(ActionEvent e){
		if(map.getMap(p.getTileX(), p.getTileY()).equals("f")){
			Message = "Winner";
			win = true;
		}
		
//		if(){
//			Message1 = "Game over!";
//			gameover = true;
//		}
		repaint();
	}
	

	
	public void paint(Graphics g){
		super.paint(g);

		if(!win){
			for(int y = 0; y < 14; y++){
				for(int x = 0; x < 14; x++){
					if(map.getMap(x, y).equals("f")){
						g.drawImage(map.getFinish(), x * 32, y * 32, null);
					}
					if(map.getMap(x, y).equals("g")){
						g.drawImage(map.getGrass(), x * 32, y * 32, null);
					}
					if(map.getMap(x, y).equals("w")){
						g.drawImage(map.getWall(), x * 32, y * 32, null);
					}
				}
			}
			if( p.getTileX() * 32 == en.getTileX() * 32 && p.getTileY() * 32 == en.getTileY() * 32 || p.getTileX() * 32 == ce.getTileX() * 32 && p.getTileY() * 32 == ce.getTileY() * 32)
			{
				Message = "g3t r3kt $0n";
				win = true;
			}
			
			g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
			g.drawImage(en.getEnemy(), en.getTileX() * 32, en.getTileY() * 32, null);
			g.drawImage(ce.getCircleEnemy(), ce.getTileX() * 32, ce.getTileY() * 32, null);
			en.move();
			ce.move();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		if (win) {
			g.setColor(Color.ORANGE);
			g.setFont(font);
			if(Message.equals("g3t r3kt $0n"))
			{
				g.drawString(Message, 100, 200);
			}
			else
			{
				g.drawString(Message, 150, 200);
			}
			
			
		}
//		  else if (gameover) {
//			g.setColor(Color.ORANGE);
//			g.setFont(font);
//			g.drawString(Message1, 150, 200);
//		}

	}
	
	public class Al extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			int keycode = e.getKeyCode();
			
			if(keycode == KeyEvent.VK_UP){
				if(!map.getMap(p.getTileX(),p.getTileY() - 1).equals("w")){
				p.move(0, -1);
				}
			}
			if (keycode == KeyEvent.VK_DOWN) {
				if(!map.getMap(p.getTileX(),p.getTileY() + 1).equals("w")){
				p.move(0, 1);
				}
			}
			if (keycode == KeyEvent.VK_LEFT) {
				if(!map.getMap(p.getTileX() - 1,p.getTileY()).equals("w")){
				p.move(-1, 0);
				}
			}
			if (keycode == KeyEvent.VK_RIGHT) {
				if(!map.getMap(p.getTileX() + 1,p.getTileY()).equals("w")){
				p.move(1, 0);
				}
			}
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		public void keyTyped(KeyEvent e){
			
		}
	}
}
