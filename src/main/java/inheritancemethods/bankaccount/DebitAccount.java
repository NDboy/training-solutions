package inheritancemethods.bankaccount;

public class DebitAccount {
    private String accountNumber;
    private long balance;

    private static final double COST = 3.0;
    private static final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount) {
        if (MIN_COST >= amount * COST / 100) {
            return MIN_COST;
        } else {
            return amount * (long) COST / 100;
        }
    }

    public void balanceToZero() {
        balance = 0;
    }

    public boolean transaction(long amount) {
        if (amount + costOfTransaction(amount) > balance) {
            return false;
        } else {
            balance -= (amount + costOfTransaction(amount));
            return true;
        }
    }

}
