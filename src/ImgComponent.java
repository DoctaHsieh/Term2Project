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
//Use ImageIO to get image and place it on the button
	protected void setImgFilePath(String imageFileName) {
		try {
			// you can either use URL or File for reading image using ImageIO
			File imagefile = new File(imageFileName);
//			System.out.println("image file absolute path is " + imagefile.getAbsolutePath());
//			System.out.println("Image file exists " + imagefile.exists());
			image = ImageIO.read(imagefile);
			Icon icon = new ImageIcon(imageFileName);
			super.setIcon(icon);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
