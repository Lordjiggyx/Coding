package Default;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//listens to mouse movements

public class CursorListener extends MouseAdapter implements MouseMotionListener {

  public CursorListener(CompositeFrame frame) {
    this.frame = frame;
    this.x = 0;
    this.y = 0;
  }

  public void mouseDragged(MouseEvent e)  {
    this.mouseMoved(e);
  }

  public void mouseMoved(MouseEvent e)  {
    /***********************************/
    //Dont care which cursor we have - no try/catch block
    frame.getCursorTracker().move(e.getX() - this.x, e.getY() - this.y);

    this.x = e.getX();
    this.y = e.getY();
    frame.repaint(1);
  }

  public void mouseEntered(MouseEvent e)  {
    this.x = e.getX();
    this.y = e.getY();

    CompositeCursor compCursor = new SnowmanCursor(e.getX(), e.getY());

   //Create cursor here - default Round Cursor
    CursorTracker cursor = compCursor;
    frame.setCursorTracker(cursor);

    //paint the new cursor
    frame.repaint(1);
  }

  public void mouseExited(MouseEvent e) {
    //System.out.println("Exited " + e.getPoint());
    this.x = 0;
    this.y = 0;
    frame.setCursorTracker(null);
    frame.repaint(1);
  }

  private CompositeFrame frame;
  private int x, y;

}