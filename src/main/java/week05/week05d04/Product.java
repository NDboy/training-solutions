package week05.week05d04;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate expiringDate;

    public Product(String name, int year, int month, int day) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty!");
        }
        this.name = name;
        this.expiringDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiringDate() {
        return expiringDate;
    }

    private boolean isEmpty (String str) {
        return str == null || str.isBlank();
    }

}
