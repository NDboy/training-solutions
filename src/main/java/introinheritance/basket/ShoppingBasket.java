package introinheritance.basket;


public class ShoppingBasket {
    private Basket basket = new Basket();


    public boolean isEmpty(String a) {
        return a == null || a.isBlank();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        if (isEmpty(barcode)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0.0;
        for (Item item: basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0.0;
        for (Item item: basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public String getMostExpensiveItemBarcode() {
        Item expensive = basket.getItems().get(0);
        for (int i = 0; i < basket.getItems().size(); i++) {
            if (basket.getItems().get(i).getNettoPrice() > expensive.getNettoPrice()) {
                expensive = basket.getItems().get(i);
            }
        }
        return expensive.getBarcode();
    }

    public void removeMostExpensiveItem() {
        basket.removeItem(getMostExpensiveItemBarcode());
    }

}
