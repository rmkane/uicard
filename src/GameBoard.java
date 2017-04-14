import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	private static final long serialVersionUID = 2558098042977111L;

	private String tileFilename = "resources/45-degree-fabric-dark.png";
	private Image tileImage = null;
	
	@SuppressWarnings("unused")
	private List<UICard> cards = new ArrayList<UICard>();

	public GameBoard() {
		UICard card = new UICard(Rank.QUEEN, Suit.HEARTS);
		loadTileImage();

		this.add(card);
		handleDrag(card);
	}

	public void handleDrag(UICard card) {
		final UICard p = card;
		card.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int cardLeft = e.getComponent().getLocation().x;
				int cardRight = e.getComponent().getLocation().y;
				e.translatePoint(cardLeft, cardRight);
				
				int mouseX = e.getX() - e.getComponent().getWidth() / 2;
				int mouseY = e.getY() - e.getComponent().getHeight() / 2;
				p.setLocation(mouseX, mouseY);
			}
		});
		
		card.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(card.toString());
			}
		});
	}

	private void loadTileImage() {
		try {
			tileImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(tileFilename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(0, 128, 0));
		g.fillRect(0, 0, getWidth(), getHeight());

		TexturePaint paint = new TexturePaint((BufferedImage) tileImage, new Rectangle(tileImage.getWidth(null), tileImage.getHeight(null)));
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setPaint(paint);
        g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
