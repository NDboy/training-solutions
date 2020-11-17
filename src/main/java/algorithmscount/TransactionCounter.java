package algorithmscount;

import java.util.List;

public class TransactionCounter {

    public int transactionCounterByAmount(List<Transaction> transactions, int limit) {
        int counter = 0;
        for (Transaction transaction: transactions) {
            if (transaction.getAmount() < limit) {
                counter++;
            }
        }
        return counter;
    }
}
