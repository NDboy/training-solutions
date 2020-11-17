package introjunit;

import introjunit.Gentleman;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemenTest {

    @Test
    public void testGentleman() {
        assertEquals("John Doe", new Gentleman("John Doe").getName());
    }

    @Test
    public void testGentleman2() {
        assertEquals("Hello John Doe", new Gentleman("John Doe").sayHello());
    }

    @Test
    public void testGentleman3() {
        assertEquals("Hello Anonymous", new Gentleman(null).sayHello());
    }

}
