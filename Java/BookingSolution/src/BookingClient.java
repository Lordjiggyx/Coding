import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingClient {
	public static final int MINATT = 25;
	public static final int MINHOURS = 2;

	protected static Date date = null;
	protected static int hours;
	protected static int attendance;
	protected static String location;
	protected static String building;
	protected static String emailAddress;
	protected static String contactNumber;
	
	private static BookingEntryDialog parentDialog;

	public BookingClient(BookingEntryDialog parentDialog, String data) {

		this.parentDialog = parentDialog;
		Booking b = new Booking();
		try {
			parse(data);
			b = build();
			parentDialog.displayResult("Booking is " + b.toString());
		}
		catch (Exception e){
			parentDialog.displayResult(e.getMessage());
		}		

	}

	@SuppressWarnings("deprecation")
	public static void parse(String s) throws ParseException {
		String[] tokens = s.split(",\\s*");
		for (int i = 0; i < tokens.length; i += 2) {
			String type = tokens[i];
			String val = tokens[i + 1];

			if ("date".compareToIgnoreCase(type) == 0) {
				Calendar now = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd");
				try {
				Date d = formatter.parse(val);//
				d.setYear(now.get(Calendar.YEAR));
				date = futurize(d);
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
			} 
			else if ("time".compareToIgnoreCase(type) == 0)
				date.setHours(Integer.parseInt(val));
			else if ("hours".compareToIgnoreCase(type) == 0) 
				hours = Integer.parseInt(val);
			else if ("attendance".compareToIgnoreCase(type) == 0) 
				attendance = Integer.parseInt(val);
			else if ("location".compareToIgnoreCase(type) == 0)
				location = val.trim();
			else if ("building".compareToIgnoreCase(type) == 0) 
				building = val.trim();
			else if ("contact".compareToIgnoreCase(type) == 0)
				emailAddress = val.trim();
			else if ("phone".compareToIgnoreCase(type) == 0)
				contactNumber = val.trim();
		}
	}

	/* Checks to see if date should be in this year or next */
	public static Date futurize(Date inDate) {
		Calendar now = Calendar.getInstance();
		Calendar then = Calendar.getInstance();
		then.setTime(inDate);

		while (then.before(now)) 
			then.add(Calendar.YEAR, 1);

		return then.getTime();
	}

	public static Booking build() throws BuilderException {
		if (date == null)
			throw new BuilderException(parentDialog, "Valid date not found");

		if (hours < MINHOURS)
			throw new BuilderException(parentDialog, "Minimum hours for booking is " + MINHOURS);

		if (attendance < MINATT)
			throw new BuilderException(parentDialog, "Minimum headcount is " + MINATT);

		if (location == null)
			throw new BuilderException(parentDialog, "Valid location not found");

		if (building == null)
			throw new BuilderException(parentDialog, "Valid building not found");

		if (emailAddress == null || !(validateEmail(emailAddress)))
			throw new BuilderException(parentDialog, "Valid email address not found");

		if (contactNumber == null || !(validatePhoneNo(contactNumber)))
			throw new BuilderException(parentDialog, "Valid contact number not found");

		return new Booking(date, hours, attendance, location, building, emailAddress, contactNumber);
	}

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	private static final Pattern VALID_PHONE_NUMBER_REGEX = 
			Pattern.compile("^\\(?[0][0-9]{1,3}\\)?\\s?[1-9][0-9]{4,6}$", Pattern.CASE_INSENSITIVE);

	private static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}

	private static boolean validatePhoneNo(String phoneStr) {
		Matcher matcher = VALID_PHONE_NUMBER_REGEX .matcher(phoneStr);
		return matcher.find();
	}
}