package algorithmsmax;

public class SalesPerson {
    private String name;
    private int amount;
    private int targetAmount;

    public SalesPerson(String name, int amount, int targetAmount) {
        this.name = name;
        this.amount = amount;
        this.targetAmount = targetAmount;
    }

    public int getAmount() {
        return amount;
    }

    public int getTargetAmount() {
        return targetAmount;
    }
}
