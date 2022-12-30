//This class places the components on panels
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import java.awt.event.*;

public class LayeredPanels extends JFrame implements KeyListener, ActionListener{
	private static final long serialVersionUID = 1L;
	
	JLayeredPane pane = getLayeredPane(); //Window
	Dinosaur dinosaur = new Dinosaur(); //Load dino
    DinoObstacle obstacle = new DinoObstacle();  //Load cacti
    DinoBackground background = new DinoBackground();  //Load ground
    Score score = new Score(); //Load Scoreboard
    
    Timer timer = new Timer(10, this); //When started, execute ActionPerformed() method every 0.01 Seconds
    
	public LayeredPanels(){  
		//Initialize window
	    setSize(1200, 650);
	    setResizable(false); // make height and width of window a defined number of pixels
	    setTitle("Dino Game"); // set title
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate program when window closes
	    setVisible(true);
	    addKeyListener(this);
	}
	
	public void loadScene() {
	    //create buttons
	    pane.add(background, new Integer(1));  
	    pane.add(obstacle, new Integer(2)); 
	    pane.add(dinosaur, new Integer(2));  
	    pane.add(score, new Integer(3));
	}

	public void startGame() {
		timer.start();
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			//Space key pressed
			dinosaur.jump();
		}
	}
	
	
	//Game clock, cycles every 0.01 seconds
	public void actionPerformed(ActionEvent e) {
		obstacle.move(); //Move obstacles
		
	}
	
	
	
	// Additional methods from KeyListener interface; not needed
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}

