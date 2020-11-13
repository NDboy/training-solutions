package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn (String ssn) {
        boolean isValidLastNumberOfSsn = Integer.parseInt(ssn.substring(8))==(Integer.parseInt(ssn.substring(0,1)) * 3 + Integer.parseInt(ssn.substring(1,2)) * 7 + Integer.parseInt(ssn.substring(2,3)) * 3 + Integer.parseInt(ssn.substring(3,4)) * 7 + Integer.parseInt(ssn.substring(4,5)) * 3 + Integer.parseInt(ssn.substring(5,6)) * 7 + Integer.parseInt(ssn.substring(6,7)) * 3 + Integer.parseInt(ssn.substring(7,8)) * 7)%10;
        try {
            int value = Integer.parseInt(ssn);
            return (ssn.length() == 9) && isValidLastNumberOfSsn;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
