package introjunit;

import introjunit.Trainer;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {
    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe");

        String name = trainer.getName();

        assertEquals("John Doe", name);
    }
    @Test
    public void testCreate2() {
        assertEquals("John Doe", new Trainer("John Doe").getName());
    }
    @Test
    public void testUppercase () {
        assertEquals("JOHN DOE", new Trainer("John Doe").getNameUppercase());

    }

}
