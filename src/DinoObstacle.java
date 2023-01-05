//This class creates the obstacle for our game
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Rectangle;
public class DinoObstacle extends ImgComponent{
	private static final long serialVersionUID = 1L;
	public int x, y, width, height, rate;

	//Create cactus obstacle
	public DinoObstacle() {
		//Initial position of obstacles
		x = 900;
		y = 400;
		width = 91;
		height = 100;
		
		//Initial rate
		rate = 10;
		super.setBounds(x, y, width, height); 
		super.setImgFilePath("assets\\images\\cactus2.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
	}
	
	public void move() {
		//Move Obstacle at specified rate
			x = x - rate;
			super.setLocation(x, y);
			if (x < -90) {
				x = randomStartVal(); //Reset obstacle to other side of screen
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
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}
}
