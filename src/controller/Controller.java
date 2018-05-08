package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import models.Game;
import views.MainWindow;


public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private Game game;

	public Controller(){
		game = new Game(500);
		mainWindow = new MainWindow(game.getLifes(),game.getPlayer(),game.getEnemyList(), game.getShots(), this);
		Timer timer = new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.repaintAll();
			}
		});
		timer.start();
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
		case KeyEvent.VK_SPACE:
			game.addShot(game.getPlayer());
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}


}