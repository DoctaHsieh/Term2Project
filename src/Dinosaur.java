//This class creates the dinosaur for our game
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Dinosaur extends ImgComponent implements ActionListener{
	private static final long serialVersionUID = 1L;
	Timer timer;
	DinoObstacle obstacle = new DinoObstacle();
	
	private int x, y; //Pos of dino
	private int width = 200;
	private int height = 165;
	private double jumpTime;
	private boolean airborne;

	Score s = new Score();
	//Create dinosaur image
	public Dinosaur() {
		x =150;
		y = 335;
		airborne = false;
		super.setBounds(x, y, width, height); //(x, y, width, height) 335 is default y value
		super.setImgFilePath("assets\\images\\dino.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
		timer = new Timer(10, this);
	}
	
	public void jump(){
		if (!airborne) {
			//Dino is not already jumping
			super.setLocation(x, y);
			jumpTime = 0;
			timer.start(); //Jump sequence
		}
	}
	
	//Jump Physics
	public void actionPerformed(ActionEvent e) {
			//Dino is airborne
			airborne = true;
			
			/*
			 * Y-Position of the dino with respect to time can be modeled with the equation:
			 * y = 2000(x-0.375)^2+50
			 * 
			 * Y --> y position
			 * X --> Seconds
			 * 
			 * This function updates every .01 seconds, with the jump lasting 0.75 seconds in total
			 */
		
		 	//Calculate position at given time
			double yPos = (jumpTime - 0.375) * (jumpTime - 0.375);
			yPos *= 2000;
			yPos += 50;
			y = (int)yPos;
			super.setLocation(x, y); //Set new location, double rounded to nearest int
			
			jumpTime += 0.01;
			
			//check if jump is complete
			if (jumpTime >= 0.76) {
				airborne = false; // dino has landed! no longer airborne
				timer.stop();
			}
			
	}
	
	public void gameOver() {
		timer.stop();
	}
	
	public void reset() {
		x =150;
		y = 335;
		airborne = false;
		super.setLocation(x, y);
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y, width, height);
	}

}

