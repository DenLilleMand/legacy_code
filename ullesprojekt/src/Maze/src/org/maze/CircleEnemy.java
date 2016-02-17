package Maze.src.org.maze;

import java.awt.*;

import javax.swing.ImageIcon;

public class CircleEnemy {

	private boolean down, up, left, right;
	
	private int tileX, tileY;
	private Image cEnemy;
	
	public CircleEnemy(){
		
		ImageIcon img = new ImageIcon("C:\\Users\\DenLilleMand\\workspace\\ullesprojekt\\circleenemy.png");
		cEnemy = img.getImage();
		
		down = false;
		up = false;
		left = false;
		right = false;
		
		tileX = 10;
		tileY = 10;
	
	}
	
	public Image getCircleEnemy(){
		return cEnemy;
	}
	
	public int getTileX(){
		return tileX;
	}
	
	public int getTileY(){
		return tileY;
	}
	
	public void move() {
		if (up) {
			tileY--;
		} else if (left) {
			tileX--;
		} else if (down) {
			tileY++;
		} else if (right) {
			tileX++;
		}

		if (tileX == 10 && tileY >= 10) {
			right = false;
			up = true;
		}
		if (tileX <= 10 && tileY == 6) {
			up = false;
			left = true;
		}
		if (tileX == 3 && tileY >= 6) {
			left = false;
			down = true;
		}
		if (tileX >= 3 && tileY == 10) {
			down = false;
			right = true;
		}
	}
}
	



