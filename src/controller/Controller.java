package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.Game;
import views.MainWindow;

public class Controller implements KeyListener{
	
	
	private MainWindow mainWindow;
	private Game game;
	
	public Controller() {
		game = new Game();
		mainWindow = new MainWindow(game.getPlayer());
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public static void main(String[] args) {
		new Controller();
	}
}
