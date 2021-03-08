package week03.week03d05;

import java.util.Scanner;

public class Operation {
    private int leftValue;
    private int rightValue;

    public Operation(String addition) {
        String[] numbers = addition.split( "\\+");
        leftValue = Integer.parseInt(numbers[0]);
        rightValue = Integer.parseInt(numbers[1]);
    }

    public int getResult() {
        return leftValue + rightValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Összeadás?");
        String addition = scanner.nextLine();
        Operation operation = new Operation(addition);

        System.out.println(operation.getResult());
    }

}
