package week05.week05d04;

import org.junit.jupiter.api.Test;
import week05.week05d03.User;
import week05.week05d03.UserValidatorSenior;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductSeniorTest {

    @Test
    void testCreate() {
        ProductSenior ps = new ProductSenior(150, "HUF");
        assertEquals(150, ps.getPrice());
        assertEquals(Currency.HUF, ps.getCurrency());
    }

    @Test
    void wrongCurrencyShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ProductSenior(150, "UF"));
        assertEquals("Wrong currency :UF. Possible: HUF, USD", ex.getMessage());
    }

    @Test
    void convertPrice() {
        ProductSenior ps = new ProductSenior(150, "HUF");
        ProductSenior ps2 = new ProductSenior(10, "USD");
        assertEquals(0.5, ps.convertPrice("USD"));
        assertEquals(150, ps.convertPrice("HUF"));
        assertEquals(3000, ps2.convertPrice("HUF"));
    }
}