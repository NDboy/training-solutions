package finalmodifier;

public class TaxCalculator {
    public static final double TAX = 27.0;
    private double price;

    public double getPrice() {
        return price;
    }
    public double tax(double price) {
        return price * TAX / 100.0;
    }

    public double priceWithTax(double price) {
        return price * (100.0 + TAX) / 100.0;
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println(taxCalculator.tax(1000));
        System.out.println(taxCalculator.priceWithTax(1000));
    }

}
