

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class LightBulbDemo extends Canvas  {
	   
	   public LightBulbDemo() {     // constructor
	       setSize(50,50);
	       setBackground(Color.GRAY);
	   }
	   // Properties
	   private static final Color COLOR_OFF = Color.BLACK;
	   private Color color = Color.ORANGE;        // property with a default value
	   public Color getColor() { return color; }  // getter
	   public void setColor(Color color) { this.color = color; } // setter
	   
	   boolean on = false;                        // property with a default value
	   public boolean isOn() { return on; }       // getter for boolean
	   public void setOn(boolean on) { this.on = on; } // setter
	   
	   // Override the paint() method to draw the LightBulb
	   public void paint(Graphics g) {
	      if (on) g.setColor(color);
	      else g.setColor(COLOR_OFF);
	      g.fillOval(10, 10, 30, 30);
	   }
	   
	   public void switchOn() {   // switch on the Light
	      on = true;
	      repaint();
	   }
	   
	   public void switchOff() {  // switch off the Light
	      on = false;
	      repaint();
	   }
	   
	   public void toggle() {   // If on turns off; else turns on
	      on = !on;
	      repaint();
	   }
	}


