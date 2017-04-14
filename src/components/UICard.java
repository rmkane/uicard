package components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import model.Card;
import model.Rank;
import model.Suit;

public class UICard extends JComponent {
	private static final long serialVersionUID = 1661874213530191469L;

	private Card card;
	private Image image;
	
	public UICard(Rank rank, Suit suit) {
		this.card = new Card(rank, suit);
		this.loadImage();
	}

	protected void loadImage() {
		try {
			System.out.println(getFileName());
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(getFileName()));
			handleResize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleResize() {
		this.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
	}

	private String getFileName() {
		return String.format("resources/%s_%s.png", getRank().name().toLowerCase(), getSuit().name().toLowerCase());
	}

	public Image getImage() {
		return image;
	}

	public Rank getRank() {
		return card.getRank();
	}
	
	public Suit getSuit() {
		return card.getSuit();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, null);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	@Override
	public String toString() {
		return card.toString();
	}
}
