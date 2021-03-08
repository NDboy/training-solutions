package week05.week05d03;

import java.util.List;

public class UserValidatorSenior {

    public void validate(List<User> users) {
        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException("List missing or empty list");
        }
        for (User user: users) {
            if (user == null) {
                throw new IllegalArgumentException("Wrong argument, the user is null");
            } else if (user.getName() == null || user.getName().isBlank()) {
                throw new IllegalArgumentException("Wrong argument, the user name is missing");
            } else if (user.getAge() <= 0 || user.getAge() > 120) {
                throw new IllegalArgumentException("Wrong argument, the age must be between 0 and 120");
            }
        }
    }
}
