//This class creates the background for our dinosaur game
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DinoBackground extends ImgComponent {

	private static final long serialVersionUID = 1L;
	
	//Get image from the assets folder for the background
	public DinoBackground() {
		super.setBounds(0, 0, 1200, 725); //Calibrated so that horizon matches up with JPanel Objects
		super.setImgFilePath("assets\\images\\background.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
	}
}
