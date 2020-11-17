package algorithmssum;

import java.util.ArrayList;
import java.util.List;

import static algorithmssum.TransactionOperation.CREDIT;
import static algorithmssum.TransactionOperation.DEBIT;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction: transactions) {
            if (transaction.getTransactionOperation() == CREDIT) {
                sum += transaction.getAmount();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("856", CREDIT, 150_000));
        transactions.add(new Transaction("852", DEBIT, 270_000));
        transactions.add(new Transaction("756", CREDIT, 90_000));
        transactions.add(new Transaction("753", DEBIT, 233_000));

        System.out.printf("A Credit tranzakciók összege: %d", (new TransactionSumCalculator().sumAmountOfCreditEntries(transactions)));
    }

}
