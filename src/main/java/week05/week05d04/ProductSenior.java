package week05.week05d04;

public class ProductSenior {
    private long price;
    private Currency currency;

    public ProductSenior(long price, String currency) {
        this.price = price;
        try {
            this.currency = Currency.valueOf(currency);
        }
        catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Wrong currency :" + currency + ". Possible: HUF, USD", iae);
        }
    }

    public long getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double convertPrice(String currency) {
        return this.price * this.currency.getValue() / Currency.valueOf(currency).getValue();
    }
}
