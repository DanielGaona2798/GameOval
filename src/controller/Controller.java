package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.Game;
import views.MainWindow;


public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private Game game;

	public Controller(){
		game = new Game();
		mainWindow = new MainWindow(game.getPlayer(), this);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
