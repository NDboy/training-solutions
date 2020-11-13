package stringconcat;

public class Employee {

    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Job must not be empty.");
        }
        this.job = job;
        if (salary % 1000 != 0) {
            throw new IllegalArgumentException("Salary must be divisible by 1000.");
        }
        this.salary = salary;
    }

    public boolean isEmpty(String a) {
        return a == null || a.equals("");
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}
