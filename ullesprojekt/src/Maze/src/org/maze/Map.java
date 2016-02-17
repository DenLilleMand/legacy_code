package Maze.src.org.maze;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner m;
	
	private String Map[] = new String[14];
	
	private Image 	grass,
					finish,
					wall;
	public Map(){
		
		ImageIcon img = new ImageIcon("C:\\Users\\DenLilleMand\\workspace\\ullesprojekt\\grass.png");
		grass = img.getImage();
		img = new ImageIcon("C:\\Users\\DenLilleMand\\workspace\\ullesprojekt\\wall.png");
		wall = img.getImage();
		img = new ImageIcon("C:\\Users\\DenLilleMand\\workspace\\ullesprojekt\\finish.png");
		finish = img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getWall(){
		return wall;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public String getMap(int x, int y){
		String index = Map[y].substring(x, x + 1);
		return index;
	}
	
	public void openFile(){
		
		try{
			m = new Scanner(new File("C:\\Users\\DenLilleMand\\workspace\\ullesprojekt\\Map.txt"));			
		}catch(Exception e){
			System.out.println("Error loading map");
		}

	}
	
	public void readFile(){
		while(m.hasNext()){
			for(int i = 0; i < 14; i++){
				Map[i] = m.next();
			}
		}
	}

	public void closeFile(){
		m.close();
	}
}
