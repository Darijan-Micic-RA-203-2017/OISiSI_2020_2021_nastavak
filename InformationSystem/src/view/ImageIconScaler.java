package view;

import java.awt.Image;

import javax.swing.ImageIcon;

/** REFERENCA: Materijali za vežbe (v5 -> b - Tabovi -> TabExample -> MainFrame.java) */
public class ImageIconScaler {
	// Konstruktor:
	public ImageIconScaler() {}
	
	// Radnja:
	public static ImageIcon scaleImageIcon(String path, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(path);
		
		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(scaledImage);
		
		return imageIcon;
	}
}
