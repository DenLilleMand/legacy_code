package Maze.src.org.maze;

import java.awt.*;

import javax.swing.*;

public class Enemy {
	
	private boolean down;

	private int tileX, tileY;
	
	private Image enemy;
	
	public Enemy(){
	
		ImageIcon img = new ImageIcon("C:\\Users\\DenLilleMand\\workspace\\ullesprojekt\\enemy.png");
		enemy = img.getImage();
		
		down = false;
		
		tileX = 6;
		tileY = 13;
	}
	
	public Image getEnemy(){
		return enemy;
	}
	
	
	public int getTileX(){
		return tileX;
	}
	
	public int getTileY(){
		return tileY;
	}
	
	
	
	public void move(){
//		tileX ++;
		if(down) {
		tileY ++;
		} else {
			tileY--;
		}
		
		
        if (tileY > 12) {
            down = false;
        } else if (1 > tileY) {
            down = true;
        }
	}
}
