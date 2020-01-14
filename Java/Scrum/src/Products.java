
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Date;

public class Products {
private String name;
private int price;
private String Type;
private Date date;
private int ID; Products(int ID, String name, String Type, int price  , java.util.Date date2){
	 this.ID= ID;
	 this.name = name;
	 this.Type = Type;
	 this.price= price;
	 this.date = date2;
	 
	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}
public void setPrices()
{
	if(this.Type.equals("Luxury"))
	{
		this.price = 50;
	}
	
	if(this.Type.equals("Essential"))
	{
		this.price = 30;
	}
	if(this.Type.equals("gift"))
	{
		this.price = 20;
	}
}
public String toString(){
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	return "Product: " + this.name +"   "+"Expriation Date" + dateFormat.format(date);
}

}