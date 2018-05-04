package models;

import java.awt.Rectangle;

public class Game {

	private Rectangle player;
	
	public Game() {
		player = new Rectangle(100,100,50,50);
	}

	public Rectangle getPlayer() {
		return player;
	}
	
	public void changeLocationRigth() {
		player.setLocation(player.x+50, player.y);
	}
	public void changeLocationLeft() {
		player.setLocation(player.x - 50, player.y);
	}
	public void changeLocationUp() {
		player.setLocation(player.x, player.y - 50);
	}
	public void changeLocationDown() {
		player.setLocation(player.x, player.y + 50);
	}
}
