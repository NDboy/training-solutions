package statements;

public class Investment {
    private double cost = 0.997;
    private double fund;
    private double interestRate;
    private boolean active = true;


    public Investment(double fund, double interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public double getYield(int days) {
        double interestPerDay = fund * interestRate / 100 / 365;
        return days * interestPerDay;
    }

    public double getFund() {
        return fund;
    }

    public double close(int days){
        double holeAmountPerDay = (getFund() + getYield(days)) *cost;
        double holePaymentPerDay = active ? holeAmountPerDay : 0;
        active = false;
        return holePaymentPerDay;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
