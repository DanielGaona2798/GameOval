package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;

public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;

	private Rectangle player;
	private List<Rectangle> enemy;
	private List<Rectangle> shots;
	private int lifes;
	
	public PanelGraphics(int lifes,Rectangle rectangle,List<Rectangle> list,List<Rectangle> list2, Controller controller) {
		this.addKeyListener(controller);
		this.player = rectangle;
		this.enemy = list;
		this.shots = list2;
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
