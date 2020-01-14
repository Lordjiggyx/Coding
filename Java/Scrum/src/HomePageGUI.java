
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTabbedPane;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Component;
import java.util.ArrayList;
public class HomePageGUI extends JFrame
{
	 ArrayList <Products>stock = new ArrayList();
	
	public HomePageGUI() {
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Stock Control");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				StockGUI g = new StockGUI(stock);
				
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Customer Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				DisplayGUI g= new DisplayGUI(stock);
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Change Calculator ");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			//	ProductMenu P = new ProductMenu();
			}
			
		});
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Packing Menu");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//SupplierMenu S = new SupplierMenu();
			}
			
		});
		
		
		
		btnNewButton_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnNewButton_3);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		getContentPane().add(btnClose);
	}
	public static void main(String args[]){
		HomePageGUI myGUI = new HomePageGUI();
		myGUI.setTitle("Home Page");
		myGUI.setSize(500,500);
		myGUI.setVisible(true);
}
}
