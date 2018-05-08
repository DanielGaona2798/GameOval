package models;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistence.TextFileManager;

public class Game extends GameThread{

	private Rectangle player;
	private ArrayList<Rectangle> enemyList;
	private ArrayList<Rectangle> shots;
	private int count;
	private int enemys;
	private TextFileManager fileManager;
	private int lifes = 3;
	
	public Game(int sleep) {
		super(sleep);
		fileManager = new TextFileManager();
		player = new Rectangle(100,300,50,50);
		enemyList = new ArrayList<>();
		shots = new ArrayList<>();
		try {
			enemyList = fileManager.readFile("src/datos/enemy.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		count ++;
		enemys ++;
		if (count == 10) {
			fileManager.writeFile(enemyList, "src/datos/enemy.txt");
			count = 0;
		}
		if (enemys == 100) {
			enemyList.add(new Rectangle(1250, 800, 50, 50));
		}
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
				lifes --;
				player.setLocation(100, 300);
			}else if (lifes == 0) {	
				JOptionPane.showMessageDialog(null, "You lose");
				System.exit(0);
			}
		}
	}

	public ArrayList<Rectangle> getShots() {
		return shots;
	}

	public int getLifes() {
		return lifes;
	}
	
}