//This class creates the ground for our dinosaur game
import java.awt.Color;

public class DinoBackground extends ImgComponent {

	private static final long serialVersionUID = 1L;
//Create green rectangle(ground)
	public DinoBackground() {
	super.setBackground(Color.green);  
    super.setBounds(0, 500, 2000, 500); 
}
}
