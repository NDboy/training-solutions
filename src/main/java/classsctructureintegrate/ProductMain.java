package classsctructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        System.out.println("A termék neve?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("A termék ára?");
        int price = scanner.nextInt();

        Product product = new Product(name, price);

        product.increasePrice(200);
        System.out.println("A megemelt ár: " + product.getPrice());
        product.decreasePrice(300);
        System.out.println("A csökkentett ár: " + product.getPrice());

    }

}
