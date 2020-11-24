package intromethods;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("John Bull", 1923, 1_500_000);
        employee.raiseSalary(900_000);
        System.out.println(employee);
    }
}
