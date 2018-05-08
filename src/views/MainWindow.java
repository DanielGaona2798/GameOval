package views;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import controller.Controller;


public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGraphics graphics;
	
	public MainWindow(int lifes,Rectangle player,List<Rectangle> list,List<Rectangle> list2 ,Controller controller) {
		this.addKeyListener(controller);
		setTitle("Runner Soft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		graphics = new PanelGraphics(lifes,player, list,list2,controller);
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
	}

	public void repaintAll() {
		graphics.repaint();
	}



}
