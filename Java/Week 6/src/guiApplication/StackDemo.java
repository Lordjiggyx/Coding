// Stack Demonstration Program
// 
package guiApplication;
import dataStructures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Since the ADT doesn't allow me to see lower parts of the stack,
// I keep track of the contents with a linked list.
// One could get the stack contents from toString(), but this much easier.
 import java.util.LinkedList;

// used to calculate the width of a string in pixels
import java.awt.FontMetrics;

public class StackDemo {
   
   Graphics2D g2;
   
   static JFrame myFrame = new JFrame("DT354-2 Stack Demonstration");
   static JPanel drawPane;
   
   private JTextField inputTF;
   JTextArea contentsTA;
   
   JScrollPane contentsSP,outputSP,drawPaneSP;
   JTextArea outputTA = new JTextArea();
   JLabel sizeLbl = new JLabel("Number of elements in stack: 0");
   static boolean showFunctions = false;
         
   static Color textColor = new Color(210,210,255);
   static Color nodeColor = new Color(1,110,218);
   static Color bgColor = new Color(47,47,63);
   static Color ptrColor = new Color(7,223,7);
   static Color valueColor = new Color(255,255,255);
   static Color objColor = Color.ORANGE;
   static Color strColor = Color.MAGENTA;
   static Color logColor = new Color(34,110,61);
   
   private LinkedStack myStack = new LinkedStack();
   private LinkedList myList = new LinkedList();
    
    
   public Component createComponents() {
      
      sizeLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
      sizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
      JLabel inputLbl = new JLabel("Enter data to push: ");
      inputLbl.setHorizontalAlignment(SwingConstants.CENTER);
      inputLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
      JLabel contentsLbl = new JLabel("Output of myStack.toString():");
      contentsLbl.setHorizontalAlignment(SwingConstants.CENTER);
      contentsLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
      
      
        
      
      // listens for a push command
      class PushListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
            String curInput = inputTF.getText();
            if (!curInput.equals("")) {
               myStack.push(curInput);
               myList.add(curInput);
               if (showFunctions) {
                  outputTA.append("\nCalled: myStack.push(\"" + curInput + "\");  // \"" 
                                    + curInput + "\" has been pushed onto the stack");
                  // used to force a scroll down
                  outputTA.setText(outputTA.getText());
               } else {
                  outputTA.append("\nPushed \"" + curInput + "\" onto the stack");
                  outputTA.setText(outputTA.getText());
               }
               sizeLbl.setText("Number of elements in stack: " + myStack.size());
               inputTF.selectAll();
               
               contentsTA.setText(myStack.toString());
               drawPane.repaint();
            } else {
               outputTA.append("\nCannot push empty data!");
               outputTA.setText(outputTA.getText());
            }
                
                
         }
      }
        
      // this panel shows the graphical representation of the stack
      class DrawStackPanel extends JPanel {
         
         
         public void paintComponent(Graphics g) {
            int curX = 80;
            int curY = 25;
            int boxHt = 30;
            
            
            
            g2 = (Graphics2D) g;
            super.paintComponent(g2); //paint background
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			                       RenderingHints.VALUE_ANTIALIAS_ON);
		      g2.setRenderingHint(RenderingHints.KEY_RENDERING,
			                       RenderingHints.VALUE_RENDER_QUALITY);
		      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			                       RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		      g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
			                       RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			                       
			   g2.setStroke(new BasicStroke((float)1.75,BasicStroke.CAP_ROUND
			     ,BasicStroke.JOIN_MITER));
			                       
			   
                 
            // need to draw each box for 
            // the border
            Dimension drawDim = this.getSize();
            g2.setBackground(bgColor);
			   g2.clearRect(0,0,drawDim.width,drawDim.height);	
			   
            g2.drawRect(0,0,drawDim.width-1,drawDim.height-1);
            
            g2.setFont(new Font("Verdana", Font.BOLD, 12));
            FontMetrics fm = g2.getFontMetrics();
            g2.setPaint(textColor);
                        
            // draw the myStack node
            g2.drawString("myStack",curX-15,curY);
            
            curY += 5;
            
            // the first box
            
            g2.setPaint(objColor);
            g2.drawRect(curX,curY,boxHt,2*boxHt);
            
            // the separator
            g2.drawLine(curX,curY + boxHt,curX + boxHt,curY + boxHt);
            
            // stack count display
            int nowSize = myStack.size();
            String curSize = "" + nowSize;
            g2.setPaint(valueColor);
            int countPad = (boxHt - fm.stringWidth(curSize))/2;
            g2.drawString(curSize,curX + countPad,curY + boxHt - 10);
            
            // draw labels on left side
            g2.setPaint(textColor);
            g2.drawString("count",curX-45,curY+boxHt-10);
            curY += boxHt;
            g2.drawString("top",curX-30,curY+boxHt-10);
            
            
            if (nowSize == 0) {
               // draw a null symbol
               g2.setPaint(ptrColor);
               g2.drawLine(curX, curY, curX + boxHt, curY+boxHt);
            } else {
               // draw the arrow to the right
               g2.setPaint(ptrColor);
               g2.drawLine(curX + (boxHt/2), curY + boxHt/2,
                           curX + (4*boxHt), curY + boxHt/2);
                           
               // arrowpoints
               g2.drawLine(curX + (4*boxHt), curY + boxHt/2,
                           curX + (4*boxHt)-4, curY + (boxHt/2)-4);
               g2.drawLine(curX + (4*boxHt), curY + boxHt/2,
                           curX + (4*boxHt)-4, curY + (boxHt/2)+4);
               
                          
               // draw label above nodes
               g2.setPaint(textColor);
               g2.drawString("[ next | element ]", curX + 4*boxHt-15, curY-5);
            }
            
            
            curX += boxHt*4;
            for (int i=myList.size()-1; i > -1; i--) {     
               
               String top =  (String) myList.get(i);
                
               // the first box
               g2.setPaint(nodeColor);
               g2.drawRect(curX,curY,2*boxHt,boxHt);
                 
               // the separator
               g2.drawLine(curX + boxHt,curY,curX + boxHt,curY + boxHt);
               
               
               
               // draw the arrow to the element
               g2.setPaint(ptrColor);
               g2.drawLine(curX + ((3*boxHt)/2), curY + boxHt/2,
                           curX + (4*boxHt), curY + boxHt/2);
               // draw arrow points
               g2.drawLine(curX + (4*boxHt), curY + boxHt/2,
                           curX + (4*boxHt)-4, curY + (boxHt/2)-4);
               g2.drawLine(curX + (4*boxHt), curY + boxHt/2,
                           curX + (4*boxHt)-4, curY + (boxHt/2)+4);
                           
               
               int elementLen = fm.stringWidth("\"" + top + "\"");
               g2.setPaint(strColor);
               // draw the element box
               g2.drawRect(curX + 4*boxHt, curY, elementLen + 10, boxHt);
               
               g2.setPaint(valueColor);
               // element data
               g2.drawString("\"" + top + "\"",curX + (4*boxHt)+ 5,curY + boxHt - 10);
               
               if (i != 0) {  
                  g2.setPaint(ptrColor);
                  // down arrow
                  g2.drawLine(curX + boxHt/2,curY + boxHt/2,curX + boxHt/2,curY + ((3*boxHt)/2));
                 
                  // arrow points
                  g2.drawLine(curX + boxHt/2,curY + ((3*boxHt)/2),
                             (curX + boxHt/2)-4,curY + ((3*boxHt)/2)-4);
                  g2.drawLine(curX + boxHt/2,curY + ((3*boxHt)/2),
                             (curX + boxHt/2)+4,curY + ((3*boxHt)/2)-4);
               } else {
                  // draw null pointer
                  g2.setPaint(ptrColor);
                  g2.drawLine(curX, curY + boxHt, curX + boxHt, curY);

                  // this is to update the scrollbars if drawing goes out of view
                  drawPane.setPreferredSize(new Dimension(400, curY + 2*boxHt));
                  drawPane.revalidate();
               }
                 
               //curX += 30;
               curY += (boxHt * 3)/2;
               
            }
                 
         }
      }

        
      inputTF = new JTextField(10);
      inputTF.setFont(new Font("Verdana", Font.BOLD, 12));
      inputTF.setHorizontalAlignment(SwingConstants.CENTER);
      inputTF.addActionListener(new PushListener());
       
      JButton pushbutton = new JButton("Push");
      pushbutton.setMnemonic(KeyEvent.VK_U);
      pushbutton.addActionListener(new PushListener());
      pushbutton.setFont(new Font("Verdana", Font.PLAIN, 22));
        
        
        
      JButton popbutton = new JButton("Pop");
      popbutton.setFont(new Font("Verdana", Font.PLAIN, 22));
      popbutton.setMnemonic(KeyEvent.VK_O);
      popbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (myStack.size() > 0) {
               String curPop = (String) myStack.pop();
               Object dummy = myList.removeLast();
               if (showFunctions) {
                   outputTA.append("\nCalled: String curPop = myStack.pop();  // Now, curPop is \"" + curPop + "\"");
                   outputTA.setText(outputTA.getText());
               } else {
                   outputTA.append("\nPopped \"" + curPop + "\" off the stack");
                   outputTA.setText(outputTA.getText());
               }
               sizeLbl.setText("Number of elements in stack: " + myStack.size());
               contentsTA.setText(myStack.toString());
               
               drawPane.repaint();
            } else {
               outputTA.append("\nCannot pop from an empty stack!");
               outputTA.setText(outputTA.getText());
            }
                
         }
      });
      
      
      JButton peekbutton = new JButton("Peek");
      peekbutton.setFont(new Font("Verdana", Font.PLAIN, 22));
      peekbutton.setMnemonic(KeyEvent.VK_E);
      peekbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (myStack.size() > 0) {
               String curPeek =  (String) myStack.peek();
               
               if (showFunctions) {
                   outputTA.append("\nCalled: String curPeek =   myStack.peek();  // Now, curPeek is \"" + curPeek + "\"");
                   outputTA.setText(outputTA.getText());
               } else {
                   outputTA.append("\nPeeked at \"" + curPeek + "\" on top of the stack");
                   outputTA.setText(outputTA.getText());
               }
               
            } else {
               outputTA.append("\nCannot peek on an empty stack!");
               outputTA.setText(outputTA.getText());
            }
                
         }
      });
      
      JButton sizebutton = new JButton("Size");
      sizebutton.setFont(new Font("Verdana", Font.PLAIN, 22));
      sizebutton.setMnemonic(KeyEvent.VK_S);
      sizebutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int curSize = myStack.size();   
            if (showFunctions) {
                outputTA.append("\nCalled: int curSize = myStack.size();  // Now, curSize is " + curSize);
                outputTA.setText(outputTA.getText());
            } else {
                outputTA.append("\nChecked the size of the stack, and it has " + curSize + " elements");
                outputTA.setText(outputTA.getText());
            }
                
         }
      });
      
      JButton isemptybutton = new JButton("isEmpty");
      isemptybutton.setFont(new Font("Verdana", Font.PLAIN, 22));
      isemptybutton.setMnemonic(KeyEvent.VK_M);
      isemptybutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            boolean empty = myStack.isEmpty();   
            if (showFunctions) {
               String msg = "Called: boolean empty = myStack.isEmpty();  // Now, empty == ";
               if (empty) {
                  msg += "true";
               } else {
                  msg += "false";
               }               
               outputTA.append("\n" + msg);
               outputTA.setText(outputTA.getText());
               
            } else {
               
               String msg = "Checked if the stack was empty,";
               if (empty) {
                  msg += " and it is empty";
               } else {
                  msg += " and it is NOT empty";
               }
               outputTA.append("\n" + msg);
               outputTA.setText(outputTA.getText());
               
            }
                
         }
      });
        
      contentsTA = new JTextArea(12,20);
      contentsTA.setFont(new Font("Verdana", Font.BOLD, 12));
      contentsTA.setEditable(false);
      contentsTA.setToolTipText("This area displays the current contents of the stack as returned by the toString() function.");
      
      contentsSP = new JScrollPane(contentsTA);
      
        
        
      outputTA = new JTextArea(5,20);
      outputTA.setText("Enter data into the stack to see a demonstration");
      outputTA.setEditable(false);
      outputTA.setFont(new Font("Verdana", Font.BOLD, 16));
      outputTA.setForeground(logColor);
      outputTA.setBackground(Color.WHITE);
      
      outputSP = new JScrollPane(outputTA);
      outputSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      
      JPanel pane = new JPanel();
      
      pane.setLayout(new BorderLayout());
      JPanel leftPane = new JPanel();
      leftPane.setLayout(new BorderLayout());
            
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(3,1));
      center.add(inputLbl);
      center.add(inputTF);
      center.add(sizeLbl);
      
      leftPane.add("Center",center);
      
      JPanel south = new JPanel();
      south.setLayout(new GridLayout(3,2));
      pushbutton.setToolTipText("Press this button to \"push\" an Object onto the stack.");
      south.add(pushbutton);
      popbutton.setToolTipText("Press this button to \"pop\" an Object off the stack.  Objects are popped off in Last-In-First-Out order.");
      south.add(popbutton);
      peekbutton.setToolTipText("Press this button to \"peek\" at an Object on top of the stack.  The top Object is returned and also remains on top of the stack.");
      south.add(peekbutton);
      sizebutton.setToolTipText("Press this button to return the number of elements currently contained within the stack.");
      south.add(sizebutton);
      isemptybutton.setToolTipText("Press this button to check if the stack is empty.");
      south.add(isemptybutton);
      
      leftPane.add("South", south);
      
      JPanel north = new JPanel();
      north.setLayout(new BorderLayout());
      north.add("North", contentsLbl);
      north.add("Center", contentsSP);
           
            
      leftPane.add("North",north);
      
      pane.add("West",leftPane);
        
                             
        
      drawPane = new DrawStackPanel();
      drawPaneSP = new JScrollPane(drawPane);
           
      
      pane.add("Center",drawPaneSP);
      pane.add("South", outputSP);
      return pane;
        
        
   }

   public void display() {

      try {
         UIManager.setLookAndFeel(
             UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (Exception e) { }

      // create the top-level container and add contents to it.
 //     StackDemo stackApp= new StackDemo();
      Component contents = this.createComponents();
      myFrame.getContentPane().add(contents, BorderLayout.CENTER);

      // listen for window closing
      myFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      
        
            
      // setup the menu bar at the top of the frame
      
      JMenuBar myMenuBar = new JMenuBar();
      myFrame.setJMenuBar(myMenuBar);
           
      
      JMenu optionsMenu = new JMenu("Options");
      JMenu colorMenu = new JMenu("Color");
      
      ButtonGroup colorGroup = new ButtonGroup();
      
      JRadioButtonMenuItem selectColor = new JRadioButtonMenuItem("Show Color Display");
      colorGroup.add(selectColor);
      colorMenu.add(selectColor);
      selectColor.setSelected(true);
      
      
      
      // makes changes when a different color is selected
      class ColorListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Show Monochrome Display")) {
               // change to black and white
               textColor = new Color(0,0,0);
               nodeColor = new Color(0,0,0);
               bgColor = new Color(255,255,255);
               ptrColor = new Color(0,0,0);
               valueColor = new Color(0,0,0);
               objColor = new Color(0,0,0);
               strColor = new Color(0,0,0);
               drawPane.repaint();
                
            } else {
               // change to color
               textColor = new Color(210,210,255);
               nodeColor = new Color(1,110,218);
               bgColor = new Color(47,47,63);
               ptrColor = new Color(7,223,7);
               valueColor = new Color(255,255,255);
               objColor = Color.ORANGE;
               strColor = Color.MAGENTA;
               drawPane.repaint();
               
            }
                
         }
      }
      
      selectColor.addActionListener(new ColorListener());
      
      JRadioButtonMenuItem selectMono = new JRadioButtonMenuItem("Show Monochrome Display");
      colorGroup.add(selectMono);
      colorMenu.add(selectMono);
      selectMono.addActionListener(new ColorListener());
      
      optionsMenu.add(colorMenu);
      optionsMenu.addSeparator();
      
      JCheckBoxMenuItem showCalls = new JCheckBoxMenuItem("Show ADT function calls?");
      showCalls.setToolTipText("Check this box if you wish to see the function call that is executed for each button.");
      
      showCalls.addItemListener( new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               // enable display of function calls
               showFunctions = true;
            } else {
               // disable function calls
               showFunctions= false;
            }

                
         }
      });
      
      optionsMenu.add(showCalls);
      
            
      myMenuBar.add(optionsMenu);
      
      
      JMenu helpMenu = new JMenu("Help");
      JMenuItem aboutMenuItem = new JMenuItem("About StackDemo");
      aboutMenuItem.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(myFrame, 
            "Stack Demonstration\n\nbeta2 - last modified Mar.23.2003\n" + 
            "Michael Park\nmmpark@radford.edu",
            "About StackDemo", JOptionPane.PLAIN_MESSAGE);
                
         }
      });
      
      helpMenu.add(aboutMenuItem);
      
      myMenuBar.add(helpMenu);
      

      myFrame.pack();
      myFrame.setSize(800,600);      
      myFrame.setVisible(true);
      
   }
}
