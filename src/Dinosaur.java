//This class creates the dinosaur for our game
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
public class Dinosaur extends ImgComponent {

	private static final long serialVersionUID = 1L;
//Create dinosaur image
	public Dinosaur() {
		super.setBackground(Color.white);
		super.setBounds(150, 335, 200, 165);
		super.setImgFilePath("assets\\images\\dino.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);

	}

}
