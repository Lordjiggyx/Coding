import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MakeOrderGui extends JFrame
{
	private JTextField text1 , text2, text3;
	private JButton submit , cancel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Vector <Product> products = new Vector <Product>();
	Vector <Orders> orders = new Vector <Orders>();
	MyTableModel2 t = new MyTableModel2();
	public MakeOrderGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300); 
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{176, 103, 71, 0};
		gbl_panel_2.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel_2.add(lblName, gbc_lblName);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
				
				JLabel lblQuantity = new JLabel("Quantity");
				GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
				gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
				gbc_lblQuantity.gridx = 0;
				gbc_lblQuantity.gridy = 1;
				panel_2.add(lblQuantity, gbc_lblQuantity);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnAddProduct = new JButton("Make Order");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				for (int i = 0 ; i<products.size(); i++)
				{
					if(products.get(i).name.equals(textField_2.getText()))
							{
							Random rand = new Random();
							int ran = rand.nextInt();
								Orders order = new Orders();
								order.setOrderid(i + ran);
								orders.add(order);
								t.addRow(orders);
							}
				}
			}
		});
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddProduct.gridx = 1;
		gbc_btnAddProduct.gridy = 2;
		panel_2.add(btnAddProduct, gbc_btnAddProduct);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false); 
				dispose();
			}
		});
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturn.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnReturn.gridx = 1;
		gbc_btnReturn.gridy = 3;
		panel_2.add(btnReturn, gbc_btnReturn);
		
		setVisible(true);
		setSize(500 , 500);
	}

		

	}

