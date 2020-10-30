package classsctructureconstructors;

public class Store {

    private String product;
    private int stock;

    public Store(String product) {
        this.product = product;
        stock = 0;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }

    public void store(int productNumber) {
        stock = stock + productNumber;
    }

    public void dispatch(int productNumber) {
        stock = stock - productNumber;
    }
}
