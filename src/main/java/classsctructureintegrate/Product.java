package classsctructureintegrate;

public class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void increasePrice(int changeOfPrice) {
        price = price + changeOfPrice;
    }

    public void decreasePrice(int changeOfPrice) {
        price = price - changeOfPrice;
    }
}
