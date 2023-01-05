//This class places the components on panels
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.event.*;

public class LayeredPanels extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JLayeredPane pane = getLayeredPane(); //Window
	Dinosaur dinosaur = new Dinosaur(); //Load dino
    DinoObstacle obstacle = new DinoObstacle();  //Load cacti
    DinoBackground background = new DinoBackground();  //Load ground
    Score score = new Score(); //Load Scoreboard
    GameOverScreen GOScreen = new GameOverScreen();
    
    Timer timer = new Timer(10, this); //When started, execute ActionPerformed() method every 0.01 Seconds
    
	public LayeredPanels(){  
		//Initialize window
	    setSize(1200, 650);
	    setResizable(false); // make height and width of window a defined number of pixels
	    setTitle("Dino Game"); // set title
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate program when window closes
	    setVisible(true);
	    this.addKeyListener(new KeyListener() {

	    	//JUMP
	    	public void keyPressed(KeyEvent e) {
	    		if(e.getKeyCode() == 32) {
	    			//Space key pressed
	    			dinosaur.jump();
	    		}
	    	}

	    	// Additional methods from KeyListener interface; not needed
	    	@Override
	    	public void keyTyped(KeyEvent e) {}
	    	@Override
	    	public void keyReleased(KeyEvent e) {}
	    	
	    });
	}
	
	public void loadScene() {
	    //create buttons
	    pane.add(background, new Integer(1));  
	    pane.add(obstacle, new Integer(3)); 
	    pane.add(dinosaur, new Integer(4));  
	    pane.add(score, new Integer(5));
	    
	    //Not always visible, but still there
		pane.add(GOScreen.restartButton, new Integer(7));
		pane.add(GOScreen.title, new Integer(7));
		pane.add(GOScreen.score, new Integer(7));
	}

	public void startGame() {
		score.setVisible(true); //show score after reset
		timer.start();
	}
	
	//method for when dino passes a cactus
	public void dinoPasses(){
		
		if(obstacle.x <= 150 && obstacle.x >= 141){
			score.addScore();
		}
	}

	
	//Game clock, cycles every 0.01 seconds
	public void actionPerformed(ActionEvent e) {
		obstacle.move(); //Move obstacles
		checkCollisions();
		dinoPasses();
	}
	
	//Check for collisions while game is running
	public void checkCollisions(){
			Rectangle obst = obstacle.getBounds();
			Rectangle dino = dinosaur.getBounds();
			if(obst.intersects(dino)){
				//Collision
				
				//stop movement
				timer.stop();
				dinosaur.gameOver();
				
				//reset positions
				dinosaur.reset();
				obstacle.reset();
				score.setVisible(false);
				
				//display game over screen
				GOScreen.finalScore(score.getScore());
				GOScreen.display();
				check.start();
			}
	}
	
	//Check when user indicates to continue
	Timer check = new Timer(250, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Check if button is clicked
			if(GOScreen.checkClicked() == true) {
				GOScreen.disappear(); //Get rid of death screen
				startGame(); //TEMPORARY -- REPLACE WITH START PROMPT
				score.resetScore();
				check.stop();
			}
		}
	});
}
