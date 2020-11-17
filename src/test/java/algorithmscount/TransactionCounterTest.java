package algorithmscount;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionCounterTest {
    @Test
    public void testTransactionCounterByAmount() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("852", TransactionType.CREDIT, 120000),
                new Transaction("853", TransactionType.CREDIT, 92000),
                new Transaction("753", TransactionType.CREDIT, 1000),
                new Transaction("543", TransactionType.DEBIT, 500),
                new Transaction("793", TransactionType.CREDIT, 1211000)
        );

        assertEquals(2, new TransactionCounter().transactionCounterByAmount(transactions, 50000));
        assertEquals(5, new TransactionCounter().transactionCounterByAmount(transactions, 5000000));
        assertEquals(0, new TransactionCounter().transactionCounterByAmount(transactions, 500));

    }
}
