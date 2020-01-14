package defualt;

import java.awt.Graphics;

//Square Cursos implementation

public class SquareCursor extends SimpleCursor {

  public SquareCursor(int x, int y) {
    super(x, y);
  }

  public void draw(Graphics g)  {
    int size = 10;
    g.drawRect(x - size / 2, y - size / 2, size, size);
  }

  public void move(int dx, int dy)  {
    this.x = this.x + dx;
    this.y = this.y + dy;
  }
}