package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a felhasználónevét!");
        String username = scanner.nextLine();

        System.out.println("Adja meg a jelszót! (legalább 8 karakter)");
        String password1 = scanner.nextLine();

        System.out.println("Mégegyszer adja meg a jelszót!");
        String password2 = scanner.nextLine();

        System.out.println("Adja meg az e-mail címét!");
        String email = scanner.nextLine();

        UserValidator uservalidator = new UserValidator(username, password1, password2, email);

        System.out.println(uservalidator.isValidUsername() ? "A felhasználónév megfelelő" : "A felhasználónév nem megfelelő");
        System.out.println(uservalidator.isValidPassword() ? "A jelszó megfelelő" : "A jelszó nem megfelelő");
        System.out.println(uservalidator.isValidEmail() ? "Az e-mail cím megfelelő" : "Az e-mail cím nem megfelelő");

    }
}
