package week02.week02d03;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean areTheyEqual(Product product) {
        return this.name.equals(product.name);
    }

    public boolean areTheyEqualHard(Product product) {
        if (this.name.equals(product.name) && Math.abs(this.code.length() - product.code.length()) <= 1) {
            return true;
        }
        return false;
    }
}
