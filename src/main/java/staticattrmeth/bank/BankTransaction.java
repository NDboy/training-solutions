package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {
    private long trxValue;
    private static int numberOfTransactions;
    private static int sumOfTrxs;
    private static long currentMinValue;
    private static long currentMaxValue;
    private static final long TRX_MIN = 1;
    private static final long TRX_MAX = 10000000;


    public BankTransaction(long trxValue) {
        if (trxValue < TRX_MIN || trxValue > TRX_MAX) {
            throw new IllegalArgumentException("Invalid argument!");
        }
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
        return numberOfTransactions == 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(sumOfTrxs / numberOfTransactions);
    }

    public static long getCurrentMinValue() {
        return numberOfTransactions == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return numberOfTransactions == 0 ? 0 : currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return BigDecimal.valueOf(sumOfTrxs);
    }

}
