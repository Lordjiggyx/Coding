package Default;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//listens to closing of frame
public class BasicWindowCloser extends WindowAdapter {

  //called when frame is closing
  public void windowClosing(WindowEvent event)  {
    System.exit(0); //kills the program when frame closed
  }

}