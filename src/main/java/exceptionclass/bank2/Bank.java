package exceptionclass.bank2;

import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("No list");
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount) {
        for (Account account: accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                if (amount > account.getBalance()) {
                    throw new InvalidBankOperationException(ErrorCode2.LOW_BALANCE);
                }
                account.subtract(amount);
                return;
            }
        }
        throw new InvalidAccountNumberBankOperationException();
    }

    public void deposit(String accountNumber, double amount) {
        for (Account account: accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                account.deposit(amount);
                return;
            }
        }
        throw new InvalidAccountNumberBankOperationException();
    }

}
