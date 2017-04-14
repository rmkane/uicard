import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import components.GameBoard;

public class App implements Runnable {
	public static final String TITLE = "Draggable Card";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	@Override
	public void run() {
		JFrame f = new JFrame(TITLE);
		GameBoard b = new GameBoard();

		b.addComponentListener(new ComponentListener() {
			@Override public void componentShown(ComponentEvent e) { }
			@Override public void componentMoved(ComponentEvent e) { }
			@Override public void componentHidden(ComponentEvent e) { }

			@Override
			public void componentResized(ComponentEvent e) {

			}
		});

		b.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		f.setContentPane(b);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new App());
	}
}
