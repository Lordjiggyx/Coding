package Default;

import java.awt.Graphics;

/************************************/
//Abstract super class of ALL cursors
//Allows clients to treat composite and simple cursors identically

public abstract class CursorTracker  {

  protected int x, y;

  protected CursorTracker(int x, int y)  {
    this.x = x;
    this.y = y;
  }

  public void add(CursorTracker c) {
    //do nothing
  }

  /**********************************/
  //abstract methods that composite and simple cursors must define.
  //Makes the pattern tick!
  public abstract void draw(Graphics g);
  public abstract void move(int dx, int dy);
  
}