package Default;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

//defines the area that the mouse cursor will be tracked

public class CompositeFrame extends JFrame  {

  public CompositeFrame() {
    super("Composite Pattern");
    this.setSize(500, 500);
    this.addWindowListener(new BasicWindowCloser());
    this.getContentPane().setBackground(Color.white);
    CursorListener listener = new CursorListener(this);
    this.addMouseListener(listener);
    this.addMouseMotionListener(listener);
    this.show();
  }

  public void paint(Graphics g) {
    super.paint(g);
    if (cursor != null)
      cursor.draw(g);
  }

  public void setCursorTracker(CursorTracker c) {
    this.cursor = c;
  }

  public CursorTracker getCursorTracker() {
    return cursor;
  }

  private CursorTracker cursor;

  public static void main(String[] args)  {
    CompositeFrame composite = new CompositeFrame();
  }

}
