package com.randyp.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Class to encapsulate SpriteSheets which contain multiple component sub-images.
 * 
 * Can both receive an initial SpriteSheet and crop out its sub-images.
 * 
 * @author Armando Penblade
 * @version 0.0.8
 */
public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	/**
	 * Method to obtain a single sub-image from the main SpriteSheet
	 * 
	 * @param x - the starting x coordinate of the desired sub-image
	 * @param y - the starting y coordinate of the desired sub-image
	 * @param width - the total width of the desired sub-image
	 * @param height - the total height of the desired sub-image
	 * @return - the requested sub-image, cropped out of the larger SpriteSheet
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
