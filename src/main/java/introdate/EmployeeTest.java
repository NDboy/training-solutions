package introdate;


public class EmployeeTest {
    public static void main(String[] args) {


        Employee employee = new Employee("John Doe", 1980,12,31);
        System.out.println("Új munkatárs adatai: " + employee.getName() + ", " + employee.getDateOfBirth());
        System.out.println("Belépés dátuma: " + employee.getBeginEmployment());


    }
}
