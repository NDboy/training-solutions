package week07.week07d02;

public interface User {

    String getUserName();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public static User of(String userName, String firstName, String lastName) {
        return new User() {
            @Override
            public String getUserName() {
                return userName;
            }

            @Override
            public String getFirstName() {
                return firstName;
            }

            @Override
            public String getLastName() {
                return lastName;
            }
        };
    }

}
