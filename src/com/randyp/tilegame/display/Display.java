package com.randyp.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Class handling the creation and basic setup of the main game display window.
 * 
 * @author Armando Penblade
 * @version 0.0.7
 */
public class Display {

	/** Main game JFrame object */
	private JFrame frame;
	
	/** Main game's Canvas object to handle graphics */
	private Canvas canvas;
	
	/** Main game's Canvas's preferred size */
	Dimension canvasSize;
	
	/** Main JFrame title */
	private String title;
	
	/** Main JFrame measurements */
	private int width, height;
	
	/**
	 * Constructor, taking in desired window title and measurements.
	 * 
	 * Calls createDisplay() in order to finalize all other JFrame parameters.
	 * 
	 * @param title - the main display window's title
	 * @param width - the main display window's starting width
	 * @param height - the main display window's starting height
	 */
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		// Call helper method to finish setting up the JFrame
		createDisplay();
	}
	
	/**
	 * Helper method to finish setting up main display's JFrame
	 */
	private void createDisplay() {
		// Create the actual JFrame using the newly set title and measurements
		frame = new JFrame(title);
		frame.setSize(width, height);
		
		// Ensure window close properly exits the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Not meant to be user-resizable
		frame.setResizable(false);
		
		// Create in the center of the screen rather than the edge
		frame.setLocationRelativeTo(null);
		
		// Make main display window visible
		frame.setVisible(true);
		
		// Create a new Canvas, using the width and height to create a dimension to
		// initialize its preferred size. Moreover, its max and min are also set
		// to these measurements to "lock" its size
		canvas = new Canvas();
		
		canvasSize = new Dimension(width, height);
		canvas.setPreferredSize(canvasSize);
		canvas.setMaximumSize(canvasSize);
		canvas.setMinimumSize(canvasSize);
		
		frame.add(canvas);
		frame.pack();
	}	
	
	/**
	 * Getter method to access the game's main Canvas object for drawing elsewhere.
	 * @return the main game Canvas, called canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}
}
