package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.Game;
import views.MainWindow;


public class Controller implements KeyListener, Runnable{

	private MainWindow mainWindow;
	private Game game;
	private Thread thread;

	public Controller(){
		game = new Game();
		mainWindow = new MainWindow(game.getPlayer(),game.getEnemy(), this);
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			game.changeLocationLeft();
			mainWindow.repaintAll();
			break;
		case KeyEvent.VK_RIGHT:
			game.changeLocationRigth();
			mainWindow.repaintAll();
			break;
		case KeyEvent.VK_DOWN:
			game.changeLocationDown();
			mainWindow.repaintAll();
			break;
		case KeyEvent.VK_UP:
			game.changeLocationUp();
			mainWindow.repaintAll();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void run() {
		while (true) {
			try {
				thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			game.searchEnemy();
			mainWindow.repaintAll();
		}
	}

}