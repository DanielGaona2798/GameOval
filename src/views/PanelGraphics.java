package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Controller;



public class PanelGraphics extends JPanel{

	private static final long serialVersionUID = 1L;

	private Rectangle rectangle;
	private Rectangle enemy;
	
	
	public PanelGraphics(Rectangle rectangle,Rectangle enemy, Controller controller) {
		this.addKeyListener(controller);
		this.rectangle = rectangle;
		this.enemy = enemy;
		Timer timer = new Timer(1, new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				coalition();
			}
		});
		timer.start();
	}
	
	protected void coalition() {
		if (rectangle.intersects(enemy)) {
			JOptionPane.showMessageDialog(this, "Perdio");
			System.exit(0);
		}
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillOval(rectangle.x,rectangle.y,(int)rectangle.getWidth(),(int)rectangle.getHeight());
		g.setColor(Color.YELLOW);
		g.fillOval(enemy.x,enemy.y,(int)enemy.getWidth(),(int)enemy.getHeight());
	}

}
