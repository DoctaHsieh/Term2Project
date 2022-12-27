//This class creates the obstacle for our game
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
public class DinoObstacle extends ImgComponent {

	private static final long serialVersionUID = 1L;
	//Create cactus obstacle
	public DinoObstacle() {
		super.setBounds(800, 335, 151, 165);
		super.setImgFilePath("assets\\images\\cactus2.png");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		super.setBorder(emptyBorder);
	}
}
