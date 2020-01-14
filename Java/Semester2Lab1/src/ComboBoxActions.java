

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxActions extends JPanel implements ItemListener {

	String[] languages = new String[]{"French", "Irish", "English", "German"};
	
	JComboBox<String> comboLanguages;
	JLabel languageSelected;
	
    public ComboBoxActions() {
        super(new BorderLayout());


        //Option(1): Setting up JComboBox with an array
        /*comboLanguages = new JComboBox<String>(languages);
        comboLanguages.addActionListener(this);*/
        
     // Option(2): Create an empty combo box with items of type String
        comboLanguages = new JComboBox<String>();
        comboLanguages.setEditable(true);
       
         
        // add items to the combo box
        comboLanguages.addItem("English");
        comboLanguages.addItem("French");
        comboLanguages.addItem("Spanish");
        comboLanguages.addItem("Japanese");
        comboLanguages.addItem("Chinese");
        
        //Lay out the demo.
        add(comboLanguages, BorderLayout.PAGE_START);
        //add label
        languageSelected = new JLabel("Language Selected: " + comboLanguages.getSelectedItem());
        //add Action Listener (needs to be added after label as this event updates the label text)
        comboLanguages.addItemListener(this);
        
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	comboLanguages.addItem(comboLanguages.getSelectedItem().toString());
            }
        });
        
        JButton removeButton  = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	comboLanguages.removeItemAt(comboLanguages.getSelectedIndex());
            }
        });
        add(addButton,BorderLayout.WEST );
        add(removeButton,BorderLayout.EAST );
 
        add(languageSelected, BorderLayout.PAGE_END);

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ComboBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ComboBoxActions newContentPane = new ComboBoxActions();
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
    

	@Override
	public void itemStateChanged(ItemEvent e) {

	    Object item = e.getItem();
	    
	    if( e.getSource() == comboLanguages)
	    {
		    if ((e.getStateChange() == ItemEvent.SELECTED))  
		    	languageSelected.setText("Language Selected: " + comboLanguages.getSelectedItem());

	    }
	}

}
