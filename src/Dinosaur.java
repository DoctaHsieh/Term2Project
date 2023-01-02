//This class creates the dinosaur for our game
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Dinosaur extends ImgComponent implements ActionListener{
	private static final long serialVersionUID = 1L;
	Timer timer;
	DinoObstacle obstacle = new DinoObstacle();
	private int yVal;
	private double jumpTime;
	private boolean airborne;
	double yPos = (jumpTime - 0.375) * (jumpTime - 0.375);

	Score s = new Score();
	//Create dinosaur image
	public Dinosaur() {
		yVal = 335;
		airborne = false;
		super.setBounds(150, yVal, 200, 165); //(x, y, width, height) 335 is default y value
		super.setImgFilePath("assets\\images\\dino.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
		timer = new Timer(10, this);
	}
	
	public void jump(){
		if (!airborne) {
			//Dino is not already jumping
			super.setLocation(150, 335);
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
			
			yPos *= 2000;
			yPos += 50;
			
			super.setLocation(150, (int) yPos); //Set new location, double rounded to nearest int
			
			jumpTime += 0.01;
			
			//check if jump is complete
			if (jumpTime >= 0.76) {
				airborne = false; // dino has landed! no longer airborne
				timer.stop();
			}
			
	}
	public boolean ObstacleCollision(){
		boolean c = false;
		if(obstacle.getX() == 150 && yPos == obstacle.getY()){
			c = true;
		} 
		return c;
	}

}

