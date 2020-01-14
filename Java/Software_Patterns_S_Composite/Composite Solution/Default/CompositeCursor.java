package Default;

import java.awt.Graphics;
import java.util.Vector;

/***************************/
//Composite Cursor implementation - now subclass of Cursor Tracker

public class CompositeCursor extends CursorTracker {

  public CompositeCursor(int x, int y) {
    super(x, y);
    this.children = new Vector();
  }

  public void add(CursorTracker c) {
    children.addElement(c);
  }

  public void draw(Graphics g)  {
    for (int i = 0; i < this.children.size(); i++)  {
      CursorTracker cursor = (CursorTracker) this.children.elementAt(i);
      cursor.draw(g);
    }
  }

  public void move(int dx, int dy)  {
    this.x = this.x + dx;
    this.y = this.y + dy;
    for (int i = 0; i < this.children.size(); i++)  {
      CursorTracker cursor = (CursorTracker) this.children.elementAt(i);
      cursor.move(dx, dy);
    }
  }

  private Vector children;
}