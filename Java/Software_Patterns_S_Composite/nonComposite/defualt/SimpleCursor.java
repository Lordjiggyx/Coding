package defualt;

import java.awt.Graphics;

//Abstract super class of all non composite cursors

public abstract class SimpleCursor {

  public SimpleCursor(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public abstract void draw(Graphics g);
  public abstract void move(int dx, int dy);

  protected int x, y;
}