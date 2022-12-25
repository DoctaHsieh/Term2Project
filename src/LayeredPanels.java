//This class places the components on panels
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class LayeredPanels extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Place the components on different panels (different z indexes)
	public LayeredPanels() {  
	    super("LayeredPane Example");  
	    setSize(1200, 650);  
	    JLayeredPane pane = getLayeredPane();  
	    //creating buttons  
	    Dinosaur dinosaur = new Dinosaur();
	    
	    DinoObstacle obstacle = new DinoObstacle();  
	    DinoBackground background = new DinoBackground();  
	    pane.add(background, new Integer(1));  
	    pane.add(obstacle, new Integer(2));  
	    pane.add(dinosaur, new Integer(2));  
	  }  
}
