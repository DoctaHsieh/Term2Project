//This class creates the ground for our dinosaur game
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DinoBackground extends ImgComponent {

	private static final long serialVersionUID = 1L;
	
	//Create green rectangle(ground)
	public DinoBackground() {
		super.setBounds(0, 0, 1200, 725); //Calibrated so that horizon matches up with JPanel Objects
		super.setImgFilePath("assets\\images\\background.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
	}
}
