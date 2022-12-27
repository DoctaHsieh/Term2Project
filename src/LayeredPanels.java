//This class places the components on panels
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.event.*;

public class LayeredPanels extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	Dinosaur dinosaur = new Dinosaur(); //Load dino
    DinoObstacle obstacle = new DinoObstacle();  //Load cacti
    DinoBackground background = new DinoBackground();  //Load ground
    
	//Place the components on different panels (different z indexes)
	public LayeredPanels() throws InterruptedException {  
		//Initialize window
	    setSize(1200, 650);
	    setResizable(false); // make height and width of window a defined number of pixels
	    setTitle("Dino Game"); // set title
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate program when window closes
	    setVisible(true);
	    addKeyListener(this);
	}
	
	public void loadScene() {
	    JLayeredPane pane = getLayeredPane();
	    
	    //create buttons
	    pane.add(background, new Integer(1));  
	    pane.add(obstacle, new Integer(2));  
	    pane.add(dinosaur, new Integer(2));  
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			System.out.print("JUMP");
			dinosaur.jump();
		}
	}
	
	
	// Additional methods from KeyListener interface; not needed
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}

