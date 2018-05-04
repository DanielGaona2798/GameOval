package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controller.Controller;



public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;

	private Rectangle rectangle;
	
	public PanelGraphics(Rectangle rectangle, Controller controller) {
		this.addKeyListener(controller);
		this.rectangle = rectangle;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillOval(rectangle.x,rectangle.y,(int)rectangle.getWidth(),(int)rectangle.getHeight());
	}

}
