package week05.week05d03;

import exceptions.polinom.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorSeniorTest {

    @Test
    void missingListShouldThrowException(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidatorSenior().validate(null));
        assertEquals("List missing or empty list", ex.getMessage());
    }

    @Test
    void missingUserShouldThrowException() {
        List<User> users = Arrays.asList(new User("John Doe", 28), null);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidatorSenior().validate(users));
        assertEquals("Wrong argument, the user is null", ex.getMessage());
    }

    @Test
    void missingUserNameShouldThrowException() {
        List<User> users = Arrays.asList(new User("John Doe", 28), new User(null, 27));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidatorSenior().validate(users));
        assertEquals("Wrong argument, the user name is missing", ex.getMessage());
    }

    @Test
    void minusAgeShouldThrowException() {
        List<User> users = Arrays.asList(new User("John Doe", -28), new User("John Bull", 27));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidatorSenior().validate(users));
        assertEquals("Wrong argument, the age must be between 0 and 120", ex.getMessage());
    }

    @Test
    void ageOver120ShouldThrowException() {
        List<User> users = Arrays.asList(new User("John Doe", 128), new User("John Bull", 27));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidatorSenior().validate(users));
        assertEquals("Wrong argument, the age must be between 0 and 120", ex.getMessage());
    }
}