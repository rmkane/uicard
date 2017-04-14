import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App implements Runnable {
	@Override
	public void run() {
		JFrame f = new JFrame("Draggable Card");
		GameBoard b = new GameBoard();
		
		b.addComponentListener(new ComponentListener() {
			@Override public void componentShown(ComponentEvent e) { }
			@Override public void componentMoved(ComponentEvent e) { }
			@Override public void componentHidden(ComponentEvent e) { }

			@Override
			public void componentResized(ComponentEvent e) {
				
			}
		});
		
		b.setPreferredSize(new Dimension(800, 600));
		
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
