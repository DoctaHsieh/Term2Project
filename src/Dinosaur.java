//This class creates the dinosaur for our game
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Dinosaur extends ImgComponent{
	private static final long serialVersionUID = 1L;
	//Create dinosaur image
	public Dinosaur() {
		super.setBounds(150, 335, 200, 165); //(x, y, width, height) 335 is default y value, 95 is apex of jump
		super.setImgFilePath("assets\\images\\dino.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
	}
	
	public void jump(){
		//On Ground
		
		//Jump up
		for (int i = 0; i < 15; i++) {
			try {
				super.setLocation(150, super.getY()-20);
			    Thread.sleep(25);
			} catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
		}
	}
}

