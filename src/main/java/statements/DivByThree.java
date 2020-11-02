package statements;

import java.util.Scanner;

public class DivByThree {
    private int number;

    public DivByThree(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a number!");
        int number = scanner.nextInt();

        DivByThree divByThree = new DivByThree(number);

        System.out.println(number % 3 == 0 ? "A szám osztható hárommal!" : "A szám nem osztható hárommal!");
    }


}
