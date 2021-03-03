package covid;

public class RegistryValidator {

    public static boolean validateName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("The name cannot be empty!");
            return false;
        }
        return true;
    }

    public static boolean validateZipCode(int zipCode) {
        if (zipCode < 1000 || zipCode > 9999) {
            System.out.println("The zip code must be 4 digits long");
            return false;
        }
        return true;
    }

    public static boolean validateAge(int age) {
        if (age <= 10 || age >= 150) {
            System.out.println("Wrong age");
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String email) {
        if (email == null || email.isBlank()) {
            System.out.println("The email cannot be empty!");
            return false;
        } else if (email.length() < 6) {
            System.out.println("The email too short, must be at least 6 characters!");
            return false;
        } else if (!email.contains("@") || !email.contains(".")) {
            System.out.println("The email must contain @ and .");
            return false;
        }
        return true;
    }

    public static boolean validateStatus(String statusString) {
        if (statusString == null || statusString.isBlank()) {
            System.out.println("The reason cannot be empty!");
            return false;
        } else if (statusString.equals("REJECTED") || statusString.equals("UNSUITABLE")){
            return true;
        }
        return false;
    }

    public static boolean parseTwoEmails(String email1, String email2) {
        if (email2 == null || !email1.equals(email2)) {
            System.out.println("The 2 email don't match!");
            return false;
        }
        return true;
    }

    public static boolean validateSsn(long ssn) {
        String ssnString = String.valueOf(ssn);
        int sum = 0;
        for (int i = 1; i < ssnString.length(); i++) {
            if (i % 2 == 1) {
                sum += Integer.parseInt(ssnString.substring(i - 1, i)) * 3;
            } else {
                sum += Integer.parseInt(ssnString.substring(i - 1, i)) * 7;
            }
        }
        if (ssnString.length() != 9 || sum % 10 != Integer.parseInt(String.valueOf(ssnString.charAt(ssnString.length() - 1)))) {
            System.out.println("Wrong social security number");
            return false;
        }
        return true;
    }

}
