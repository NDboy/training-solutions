package algorithmsdecision;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String accountNumber;
    private TransactionOperation transactionOperation;
    private int amount;
    private LocalDateTime dateOfTransaction;
    private Status status;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount, LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionOperation getTransactionOperation() {
        return transactionOperation;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isCredit() {
        boolean switcher = false;
        if (getTransactionOperation() == TransactionOperation.CREDIT) {
            switcher = true;
        }
        return switcher;
    }

    public boolean isDebit() {
        boolean switcher = false;
        if (getTransactionOperation() == TransactionOperation.DEBIT) {
            switcher = true;
        }
        return switcher;
    }


}
