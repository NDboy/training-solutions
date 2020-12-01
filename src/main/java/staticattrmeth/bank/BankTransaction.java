package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {
    private long trxValue;
    public static int numberOfTransactions;
    public static int sumOfTrxs;
    public static long currentMinValue;
    public static long currentMaxValue;

    public BankTransaction(long trxValue) {
        this.trxValue = trxValue;
        numberOfTransactions++;
        if (currentMinValue == 0 || trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        if (currentMaxValue == 0 || trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }
        sumOfTrxs += trxValue;
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static void initTheDay() {
        currentMinValue = 0;
        currentMaxValue = 0;
        numberOfTransactions = 0;
        sumOfTrxs = 0;
    }

    public static BigDecimal averageOfTransaction() {
        BigDecimal average = BigDecimal.valueOf(sumOfTrxs / numberOfTransactions);
        return average;
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return BigDecimal.valueOf(sumOfTrxs);
    }

}
