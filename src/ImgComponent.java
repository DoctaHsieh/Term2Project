//This class allows DInosar and DinoObstacle to get their image
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImgComponent extends JLabel {
	private BufferedImage image;
	protected String imageFilePath = "assets\\images\\";

	public ImgComponent() {

	}
//Use ImageIO to get image
	protected void setImgFilePath(String imageFileName) {
		try {
			// use file path for reading image using ImageIO
			File imagefile = new File(imageFileName);
			image = ImageIO.read(imagefile);
			// make the image an icon so it can be placed on JLabel
			Icon icon = new ImageIcon(imageFileName);
			super.setIcon(icon);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
