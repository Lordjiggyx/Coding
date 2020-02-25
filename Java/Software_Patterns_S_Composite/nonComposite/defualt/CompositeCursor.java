package defualt;

import java.awt.Graphics;
import java.util.Vector;

//Compositions of simple and composite cursors

public class CompositeCursor  {

  public CompositeCursor(int x, int y) {
    this.children = new Vector();
    this.x = x;
    this.y = y;
  }

  public void add(SimpleCursor c) {
    children.addElement(c);
  }

  public void add(CompositeCursor c) {
    children.addElement(c);
  }

  public void draw(Graphics g)  {
    for (int i = 0; i < this.children.size(); i++)  {
      SimpleCursor cursor = (SimpleCursor) this.children.elementAt(i);
      cursor.draw(g);
    }
  }

  public void move(int dx, int dy)  {
    this.x = this.x + dx;
    this.y = this.y + dy;
    for (int i = 0; i < this.children.size(); i++)  {
      SimpleCursor cursor = (SimpleCursor) this.children.elementAt(i);
      cursor.move(dx, dy);
    }
  }

  private Vector children;
  private int x, y;

}