package com.randyp.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Basic class to load image files from resources
 * 
 * @author Armando Penblade
 * @version 0.0.7
 */
public class ImageLoader {

	/**
	 * Main useful method: return a BufferedImage from the designated path
	 * 
	 * @param path - Where the Image is stored on the PC
	 * @return - a BufferedImage representing the loaded image
	 */
	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
}
