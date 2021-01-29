package lambdacomparator.cloud;

import org.jetbrains.annotations.NotNull;

public class CloudStorage implements Comparable<CloudStorage>{

    private String provider;
    private int space;
    private PayPeriod payPeriod;
    private double price;

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this.provider = provider;
        this.space = space;
        this.payPeriod = payPeriod;
        this.price = price;
    }

    @Override
    public int compareTo(@NotNull CloudStorage o) {
        if (this.payPeriod == null || o.payPeriod == null) {
            return 0;
        }
//        return (int)(this.price/this.payPeriod.getLength()/this.space - o.price/o.payPeriod.getLength()/o.space);
        return Double.compare(this.price/this.payPeriod.getLength()/this.space, o.price/o.payPeriod.getLength()/o.space);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return payPeriod;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return provider + " " + space + " " + payPeriod + " " + price + "\n";
    }
}
