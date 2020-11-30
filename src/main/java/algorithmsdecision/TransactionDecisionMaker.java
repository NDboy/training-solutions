package algorithmsdecision;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {


        public boolean containsCreditEntryGreaterThan(List<Transaction> transactionList, LocalDateTime startDate, LocalDateTime endDate, int limit) {
            for (Transaction transaction: transactionList) {
                if (transaction.getTransactionOperation().equals(TransactionOperation.DEBIT)
                        && transaction.getDateOfTransaction().isAfter(startDate)
                        && transaction.getDateOfTransaction().isBefore(endDate)
                        && transaction.getAmount() > limit) {
                    return true;
                }
            }
            return false;
        }

    }


