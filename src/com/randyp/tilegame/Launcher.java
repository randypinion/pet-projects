package com.randyp.tilegame;

/**
 * Main launcher for TileRPG 1!
 * 
 * @author Armando Penblade
 * @version 0.0.7
 */
public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Tile Game", 640, 360);
		
		game.start();
	}
}
