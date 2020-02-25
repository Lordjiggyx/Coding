package Default;

import java.awt.Graphics;

/***************************/
//Square Cursor implementation - now subclass of Cursor Tracker

public class SquareCursor extends CursorTracker {

	//size parameterized
	
	private int size;

	public SquareCursor(int x, int y, int size) {
		super(x, y);
		this.size = size;
	}

 	public SquareCursor(int x, int y) {
		super(x, y);
		this.size = 10;
	}

	public void draw(Graphics g)  {
		g.drawRect(x - size / 2, y - size / 2, size, size);
	}

	public void move(int dx, int dy)  {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
}