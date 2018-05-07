package models;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Game extends GameThread{

	private Rectangle player;
	private ArrayList<Rectangle> enemyList;
	private ArrayList<Rectangle> shots;
	
	public Game(int sleep) {
		super(sleep);
		player = new Rectangle(100,300,50,50);
		enemyList = new ArrayList<>();
		shots = new ArrayList<>();
		enemyList.add(new Rectangle(10, 10, 50, 50));
		enemyList.add(new Rectangle(1250, 800, 50, 50));
		start();
	}

	public Rectangle getPlayer() {
		return player;
	}
	
	public void addShot(Rectangle rectangle) {
		shots.add(new Rectangle(rectangle.x,rectangle.y,15,15));
	}
	
	public void moveShot() {
		for (Rectangle rectangle : shots) {
			rectangle.setLocation(rectangle.x +100, rectangle.y);
		}
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


	public void searchEnemy() {
		for (Rectangle rectangle : enemyList) {
			if (player.x > rectangle.x) {
				rectangle.setLocation(rectangle.x+50, rectangle.y);
			}if (player.x < rectangle.x) {
				rectangle.setLocation(rectangle.x-50, rectangle.y);
			}if (player.y > rectangle.y) {
				rectangle.setLocation(rectangle.x, rectangle.y+50);
			}if (player.y < rectangle.y) {
				rectangle.setLocation(rectangle.x, rectangle.y-50);
			}
		}
		
	}

	@Override
	public void executeTask() {
		searchEnemy();
		moveShot();
		coalition();
		coalitionShot();
	}

	private void coalitionShot() {
		for (Rectangle rectangle : enemyList) {
			for (Rectangle shot : shots) {
				if (shot.intersects(rectangle)) {
					enemyList.remove(rectangle);
				}
			}
		}
	}

	public ArrayList<Rectangle> getEnemyList() {
		return enemyList;
	}
	
	public void coalition() {
		for (Rectangle rectangle : enemyList) {
			if (rectangle.intersects(player)) {
				JOptionPane.showMessageDialog(null, "You Lose");
				System.exit(0);

			}
		}
	}

	public ArrayList<Rectangle> getShots() {
		return shots;
	}
	
}
