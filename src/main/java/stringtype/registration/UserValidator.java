package stringtype.registration;

public class UserValidator {
    private String username;
    private String password1;
    private String password2;
    private String email;

    public UserValidator(String username, String password1, String password2, String email) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
    }

    public boolean isValidUsername() {
        boolean validUserName = ! username.equals("");
        return validUserName;
    }
    public boolean isValidPassword() {
        boolean validPassword = password1.equals(password2) && password1.length() >= 8;
        return validPassword;
    }
    public boolean isValidEmail() {
        int emailLength = email.length();
        boolean validEmail = (email.indexOf("@", 0) >= 1) && (email.indexOf(".", 0) >= 3) && (email.indexOf(".", 0) > (email.indexOf("@", 0) + 1)) && email.indexOf(".", 0) < (emailLength -1);
        return validEmail;
    }



}
