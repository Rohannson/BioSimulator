package BioGrowth;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyCanvas extends JPanel {

	private static final long serialVersionUID = 1L;

	ArrayList<BGStem> Stems = new ArrayList<>();

	private int counter = 0;
	private Color color = null;

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public ArrayList<BGStem> GetStems() {
		return this.Stems;
	}

	public void clear() {
		this.counter = 0;
		this.Stems.clear();
	}

	public void addStem(BGStem bGStem) {
		this.Stems.add(bGStem);
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		Dimension size = getSize();

		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, size.width, size.height);

		float MainWidth = 2.0f;
		float LeefWidth = 1.0f;

		if (this.GetStems().size() != 0) {
			for (int index = 0; index < counter; index++) {
				color = Stems.get(index).getColor();
				if (color == Color.GREEN) {
					LeefWidth *= 0.95;
					g2d.setStroke(new BasicStroke(LeefWidth));
				} else {
					MainWidth *= 0.95;
					g2d.setStroke(new BasicStroke(MainWidth));
				}
				g2d.setColor(color);
				g2d.drawLine((int) Stems.get(index).getStart()[0], (int) Stems.get(index).getStart()[1],
						(int) Stems.get(index).getEnd()[0], (int) Stems.get(index).getEnd()[1]);
			}
		}

	}

}
