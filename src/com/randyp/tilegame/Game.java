package com.randyp.tilegame;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.randyp.tilegame.display.Display;
import com.randyp.tilegame.gfx.ImageLoader;
import com.randyp.tilegame.gfx.SpriteSheet;

/**
 * Main game logic and base code. Starts everything, runs everything, and closes out at the end.
 * 
 * @author Armando Penblade
 * @version 0.0.8
 */
public class Game implements Runnable {
	
	/** The main game window's Display object */
	private Display display;
	
	/** The game window's default measurements */
	public int width, height;
	
	/** The game window's default title */
	public String title;
	
	/** Main Game loop's thread */
	private Thread thread;
	
	/** The Canvas our game is being drawn on */
	private Canvas canvas;
	
	/** This is the method by which our Canvas draws to the screen */
	private BufferStrategy bs;
	
	/** The number of buffers to use in the Canvas */
	private static final int BUFFERS = 3;
	
	/** The drawing Graphics Object from our Canvas */
	private Graphics g;
	
	/** Variable to track whether or not the Game is actually running */
	private boolean running = false;
	
	/** The test SpriteSheet for this game */
	private BufferedImage test;
	
	/** The SpriteSheet object for this game to divvy up larger SpriteSheets */
	private SpriteSheet sheet;

	/**
	 * Default Constructor, taking in parameters to setup the main game display, then
	 * actually creating said Display.
	 * 
	 * @param title - the main display window's title
	 * @param width - the main display window's starting width
	 * @param height - the main display window's starting height
	 */
	public Game(String title, int width, int height) {
		// Initialize the main game window's parameters
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	/**
	 * Helper method to setup the game's initial state
	 */
	private void init() {
		// Setup the game's main Display object
		display = new Display(title, width, height);
		
		// Load a test spritesheet
		test = ImageLoader.loadImage("/textures/sheet.png");
		
		// Give said spritesheet to the sub-class so it can be divided
		sheet = new SpriteSheet(test);
		
		// Initialize the Canvas as necessary
		canvas = display.getCanvas();
	}
	
	/**
	 * Helper method to perform all game Updates at each tick in the simulation
	 */
	private void tick() {
		
	}
	
	/**
	 * Helper method to perform all game draws to the Canvas at each tick in the simulation
	 */
	private void render() {
		// Get the Canvas's current BufferStrategy
		bs = canvas.getBufferStrategy();
		
		// On first-run, there's no bs yet, so instead create one with the correct value (3) and quit
		if (bs == null) {
			canvas.createBufferStrategy(BUFFERS);
			return;
		}
		
		// Now, grab the BS's Graphics object to paint with
		g = bs.getDrawGraphics();
		
		// Clear Screen before drawing
		g.clearRect(0, 0, width, height);
		
		// Draw Here!
		
		// End Drawing!
		
		// Swap buffers as needed in order to move the just-drawn items to the screen
		bs.show();
		
		// Dump the current Graphics object to garbage-collect
		g.dispose();
	}
	
	/**
	 * Main game method, called by the Thread starting itself
	 */
	public void run() {
		
		// Initialize the graphics of the game
		init();
		
		// Main game loop: advance the tick and perform updates, then re-draw as necessary
		while(running) {
			tick();
			render();
		}
		
		stop();
	}
	
	/**
	 * Method to start a new Thread for the Game, synchronized
	 */
	public synchronized void start() {
		// So long as the game isn't running yet, go ahead and start it up and then start the thread
		if (!running) {
			running = true;
			thread = new Thread(this);

			// This will call run()
			thread.start();
		}
	}
	
	/**
	 * Safely stop our thread as needed, if possible. Any InterruptedExceptions are caught
	 * and print a stacktrace to the console.
	 */
	public synchronized void stop() {
		// So long as the game is already running, go ahead and stop it and then kill the thread
		if (running) {
			
			running = false;
			
			// To be safe, attempt to join() (kill) the thread
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
