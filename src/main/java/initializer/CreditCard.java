package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private long balance;
    private Currency currency;
    public static final List<Rate> RATES = new ArrayList<>();

    private long conversion(Currency currency, long sum) {
        for (Rate rate: RATES) {
            if (rate.getCurrency() == currency) {
                sum *= rate.getConversionFactor();
            }
        }
        return sum;
    }

    public CreditCard(long balance, Currency currency, List<Rate> upload) {
        RATES.addAll(upload);
//        conversion(currency, balance);
        this.balance = conversion(currency, balance);
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

     public boolean payment(long amount, Currency currency) {
        long temp = conversion(currency, amount);
        if (temp > 0 && temp <= balance) {
            balance -= temp;
            return true;
        }
        return false;
    }

}
