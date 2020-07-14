import javax.swing.*;

public class BuilderException extends Exception {

    public BuilderException() {
    }

    public BuilderException(BookingEntryDialog parent, String s) {
    	JOptionPane.showMessageDialog(parent, s, "Exception generated", JOptionPane.ERROR_MESSAGE);
    }
}