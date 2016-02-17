package Maze.src.org.maze;

import javax.swing.*;

public class MazeGame {
		public static void main(String args[])
		{
			new MazeGame();
		}
		
		public MazeGame(){
			JFrame f = new JFrame();
			f.setTitle("Maze Runner Game");
			f.add(new Board());
			f.setSize(448,470);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}

}
