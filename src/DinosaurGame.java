import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class DinosaurGame{
	public static void main(String[] args) throws InterruptedException {
		boolean running = true;
		boolean collisionCheck = false;
		//Create window in which the game takes place
		LayeredPanels panel = new LayeredPanels();
		DinoObstacle obst = new DinoObstacle();
		panel.loadScene();
		panel.startGame();
		while (running == true){
			collisionCheck = panel.ObstacleCollision();
		}
		if(collisionCheck = true){
			System.out.println(collisionCheck); 
		}
		}
	
}
