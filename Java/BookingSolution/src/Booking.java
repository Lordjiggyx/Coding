import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements Serializable {
    private Date date;
	
	private int hours;
	
    private int attendance;

    private String location;
	
	private String building;

	private String emailAddress;
	
	private String contactNumber;
	
	private double price;
	
	public Booking() {
	
	}

    public Booking(Date date, int hours, int attendance, String location, String building, String emailAddress, String contactNumber) {
        this.date = date;
        this.hours = hours;
		this.attendance = attendance;
        this.location = location;
        this.building = building;
        this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
		price = calculatePrice(hours, attendance);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\nDate: ");
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm");  
        String strDate = formatter.format(date); 
        sb.append(strDate);
        sb.append("\nHours: ");
        sb.append(hours);
        sb.append("\nAttendance: ");
        sb.append(attendance);
        sb.append("\nLocation: ");
        sb.append(location);
        sb.append("\nBuilding: ");
        sb.append(building);
        sb.append("\nEmail address: ");
        sb.append(emailAddress);
        sb.append("\nContact number: ");
        sb.append(contactNumber);
        sb.append("\nPrice: ");
        NumberFormat frmt = NumberFormat.getCurrencyInstance();
        String moneyString = frmt.format(price);
        sb.append(moneyString);
        return sb.toString();
    }

    public Date getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public int getAttendance() {
        return attendance;
    }
	
    public String getLocation() {
        return location;
    }

    public String getBuilding() {
        return building;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public double getPrice() {
        return price;
    }
	
	@SuppressWarnings("deprecation")
	public double calculatePrice(int hours, int attendance) {
		double costPerHour = 0.0;
		if (attendance < 100) costPerHour = 80.0;
		else if (attendance < 200) costPerHour = 100.0;
		else if (attendance >= 200) costPerHour = 125.0;
		
		int start = date.getHours();
		
		if ((start + hours) > 24)
			costPerHour *= 1.25;
		
		return costPerHour * hours;
	}

 }