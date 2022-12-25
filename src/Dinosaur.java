//This class creates the dinosaur for our game
import java.awt.Color;

public class Dinosaur extends ImgComponent {

	private static final long serialVersionUID = 1L;
//Create dinosaur image
	public Dinosaur() {
		super.setBackground(Color.white);
		super.setBounds(100, 335, 200, 165);
		super.setImgFilePath("assets\\images\\dino.png");

	}

}
