package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount{
    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        if (amount + costOfTransaction(amount) > getBalance() + overdraftLimit) {
            return false;
        } else if (amount + costOfTransaction(amount) < getBalance() + overdraftLimit && getBalance() < amount + costOfTransaction(amount)) {
            overdraftLimit -= (amount + costOfTransaction(amount) - getBalance());
            balanceToZero();
            return true;
        } else {
            return super.transaction(amount);
        }
    }
}
