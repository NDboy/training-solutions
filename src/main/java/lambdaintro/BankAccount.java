package lambdaintro;

import org.jetbrains.annotations.NotNull;

public class BankAccount implements Comparable<BankAccount>{
    private String accountNumber;
    private String nameOfOwner;
    private double balance;

    public BankAccount(String accountNumber, String nameOfOwner, double balance) {
        this.accountNumber = accountNumber;
        this.nameOfOwner = nameOfOwner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(@NotNull BankAccount o) {
        return this.accountNumber.compareTo(o.accountNumber);
    }
}
