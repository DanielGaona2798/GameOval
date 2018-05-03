package views;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;


public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGraphics graphics;
	
	public MainWindow(Rectangle player) {
		setTitle("Runner Soft");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		graphics = new PanelGraphics(player);
		add(graphics, BorderLayout.CENTER);
		setVisible(true);
	}

}
