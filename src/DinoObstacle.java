//This class creates the obstacle for our game
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DinoObstacle extends ImgComponent{
	private static final long serialVersionUID = 1L;
	private int rate; //Number of pixels obstacle will move every 0.01 seconds
	
	//Create cactus obstacle
	public DinoObstacle() {
		rate = 10; // Initial speed of obstacles
		super.setBounds(900, 400, 91, 100); 
		super.setImgFilePath("assets\\images\\cactus2.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
	}
	
	public void move() {
		//Move Obstacle at specified rate
				setLocation(getX() - rate, getY());
				if (getX() < -90) {
					setLocation(randomStartVal(), getY()); //Reset to right side of screen
				}
	}
	
	private int randomStartVal() {
		//Return a number between 1200 and 2000
		double rand = Math.random(); //Random Num 0 - 1
		int val = (int) ((800 * rand) + 1200);
		return val;
	}
	
	public void newSpeed(int newSpeed) {
		rate = newSpeed; // set new rate
	}
}
