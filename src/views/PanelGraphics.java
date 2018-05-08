package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;

public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;

	private Rectangle player;
	private ArrayList<Rectangle> enemy;
	private ArrayList<Rectangle> shots;
	private int lifes;
	
	public PanelGraphics(int lifes,Rectangle rectangle,ArrayList<Rectangle> enemy,ArrayList<Rectangle> shots, Controller controller) {
		this.addKeyListener(controller);
		this.player = rectangle;
		this.enemy = enemy;
		this.shots = shots;
		this.lifes = lifes;
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.RED);
		g.drawString(String.valueOf(lifes), 10, 10);
		g.drawString("lifes", 0, 20);
		g.setColor(Color.BLUE);
		g.fillOval(player.x,player.y,(int)player.getWidth(),(int)player.getHeight());
		g.setColor(Color.YELLOW);
		for (Rectangle rectangle : enemy) {
			g.fillOval(rectangle.x,rectangle.y,(int)rectangle.getWidth(),(int)rectangle.getHeight());
		}
		g.setColor(Color.BLACK);
		for (Rectangle rectangle : shots) {
			g.fillOval(rectangle.x,rectangle.y,(int)rectangle.getWidth(),(int)rectangle.getHeight());
		}
	}


}
