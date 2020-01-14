package defualt;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

//Display area that the mouse cursor will be tracked

public class CompositeFrame extends JFrame  {

  public CompositeFrame() {
    super("Composite Pattern");
    this.setSize(500, 500);
    //this.cursor = new SquareCursor(0, 0);
    this.addWindowListener(new BasicWindowCloser());
    this.getContentPane().setBackground(Color.white);
    CursorListener listener = new CursorListener(this);
    this.addMouseListener(listener);
    this.addMouseMotionListener(listener);
    this.show();
  }

  public void paint(Graphics g) {
    super.paint(g);
    if (cursor != null) {
      /*******************************/
      //we have to check which type of cursor we have
      try {
      SimpleCursor tempCursor = (SimpleCursor) cursor;
      tempCursor.draw(g);
      }
      catch (ClassCastException cce)  {
        CompositeCursor tempCursor = (CompositeCursor) cursor;
        tempCursor.draw(g);
      }
    }
  }

  public void setCursorTracker(Object c) {
    this.cursor = c;
  }

  public Object getCursorTracker() {
    return cursor;
  }

  private Object cursor;  //the cursor that follows the mouse

  public static void main(String[] args)  {
    CompositeFrame composite = new CompositeFrame();
  }

}
