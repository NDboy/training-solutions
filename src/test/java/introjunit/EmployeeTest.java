package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
    @Test
    public void testCreate() {

        Employee employee = new Employee("John");

        String resultName = employee.getName();

        assertEquals("John", resultName);

    }
}
