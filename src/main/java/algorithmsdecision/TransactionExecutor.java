package algorithmsdecision;

import java.util.List;

public class TransactionExecutor {
    public void executeTransactions(List<Transaction> transactions, List<BankAccount> bankAccounts) {
        for (Transaction transaction: transactions) {
            for (BankAccount bankAccount: bankAccounts) {
                if (transaction.getAccountNumber().equals(bankAccount.getAccountNumber())) {
                    if (transaction.getTransactionOperation() == TransactionOperation.DEBIT && bankAccount.getBalance() >= transaction.getAmount()) {
                        bankAccount.withdraw(transaction.getAmount());
                        transaction.setStatus(Status.SUCCEEDED);
                    } else if (transaction.getTransactionOperation() == TransactionOperation.CREDIT) {
                        bankAccount.deposit(transaction.getAmount());
                        transaction.setStatus(Status.SUCCEEDED);
                    } else {
                        transaction.setStatus(Status.PENDING);
                    }
                }
            }
        }
    }
}
