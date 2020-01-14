package Default;

import java.awt.Graphics;

public class SnowmanCursor extends CompositeCursor {

	public SnowmanCursor(int x, int y) {

		super(x, y);
		// body
	    add(new RoundCursor(x, y, 50));
	    // head
	    add(new RoundCursor(x, y - 40, 30));
	    // buttons
	    add(new SquareCursor(x, y, 5));
	    add(new SquareCursor(x, y - 10, 5));
	    add(new SquareCursor(x, y + 10, 5));
	    // arms
	    add(new SquareCursor(x - 30, y, 10));
	    add(new SquareCursor(x + 30, y, 10));
	    // hat
	    add(new SquareCursor(x, y - 60, 10));

	}

}
