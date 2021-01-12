package ioreadstring.transaction;

public class Transaction {
    private String accountNumber;
    private int amount;

    public Transaction(String accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }
}
