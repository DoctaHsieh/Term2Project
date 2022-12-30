import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class DinosaurGame{
	public static void main(String[] args) throws InterruptedException {
		boolean running = true;
		//Create window in which the game takes place
		LayeredPanels panel = new LayeredPanels();
		panel.loadScene();
		panel.startGame();
	}
}