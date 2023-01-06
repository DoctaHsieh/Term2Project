//This class creates the dinosaur for our game
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Dinosaur extends ImgComponent{
	private static final long serialVersionUID = 1L;
	DinoObstacle obstacle = new DinoObstacle();
	
	private int x, y; //Pos of dino
	private int width = 200;
	private int height = 165;
	private double jumpTime;
	private boolean airborne, initJump;

	Score s = new Score();
	//Create dinosaur image
	public Dinosaur() {
		initJump = false;
		x =150;
		y = 335;
		airborne = false;
		super.setBounds(x, y, width, height); //(x, y, width, height) 335 is default y value
		super.setImgFilePath("assets\\images\\dino.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
		setVisible(false); //initial
	}
	
	public void jump() {
		initJump = true;
	}
	
	public void animate(){
		//Only jump when space bar is pressed (when initJump is true
		if(initJump) {
			if (!airborne) {
				//Dino is not already jumping; start jump
				super.setLocation(x, y);
				jumpTime = 0;
			
				airborne = true;
			}
			
			//Jump Physics
			if(airborne) {
				/*
				 * Y-Position of the dino with respect to time can be modeled with the equation:
				 * y = 2900(x-0.3)^2+75
				 * 
				 * Y --> y position
				 * X --> Seconds
				 * 
				 * This function updates every .01 seconds, with the jump lasting 0.75 seconds in total
				 */
			
			 	//Calculate position at given time
				double yPos = (jumpTime - 0.3) * (jumpTime - 0.3);
				yPos *= 2900;
				yPos += 75;
				y = (int)yPos;
				super.setLocation(x, y); //Set new location, double rounded to nearest int
				
				jumpTime += 0.01;
				
				//check if jump is complete
				if (jumpTime >= 0.61) {
					super.setLocation(x, y);
					airborne = false; 
					initJump=false; // dino has landed! no longer airborne
				}
			}
		}
	}
	
	public void reset() {
		x =150;
		y = 335;
		airborne = false;
		initJump = false;
		super.setLocation(x, y);
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y, width, height);
	}

}

