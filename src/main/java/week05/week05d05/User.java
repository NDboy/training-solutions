package week05.week05d05;

public class User {
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(email)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email must contain @ and . !");
        }
        this.email = email;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private boolean isValidEmail(String str) {
        if (str.contains("@") && str.contains(".")) {
            return true;
        }
        return false;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        return sb.append(firstName+ " ").append(lastName).toString();
    }



    /*  Készíts egy osztályt week05d05.User néven,
    melynek van egy firstName (String), egy lastName (String) és egy email (String) mezője.
    Legyen ellenőrzés az User konstruktorában, mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben!
    Készíts egy metódust is getFullName névvel, mely visszaadja a firstName és a lastName változókat összefűzve. Legyen közöttük egy whitespace (" ").
    Bónusz feladat: írjunk teszteket */

}
