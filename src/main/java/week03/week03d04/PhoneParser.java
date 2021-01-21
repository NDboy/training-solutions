package week03.week03d04;

public class PhoneParser {
    private String phoneNumber;


    public Phone parsePhone(String phoneNumber) {
//        phone.setPrefix(phoneNumber.substring(0,2));
        String prefix = phoneNumber.substring(0,2);
        String number = phoneNumber.substring(3);
        Phone phone = new Phone(prefix, number);
        return phone;
    }



    public static void main(String[] args) {
        PhoneParser parser = new PhoneParser();
        System.out.println(parser.parsePhone("123456789"));

    }
}
