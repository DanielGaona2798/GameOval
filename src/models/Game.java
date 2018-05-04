package models;

import java.awt.Rectangle;

public class Game {

	private Rectangle player;
	private Rectangle enemy;
	
	public Game() {
		player = new Rectangle(100,100,50,50);
		enemy = new Rectangle(10, 10, 50, 50);
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

	public Rectangle getEnemy() {
		return enemy;
	}

	public void searchEnemy() {
		if (player.x > enemy.x) {
			enemy.setLocation(enemy.x+50, enemy.y);
		}if (player.x < enemy.x) {
			enemy.setLocation(enemy.x-50, enemy.y);
		}if (player.y > enemy.y) {
			enemy.setLocation(enemy.x, enemy.y+50);
		}if (player.y < enemy.y) {
			enemy.setLocation(enemy.x, enemy.y-50);
		}
	}
}
