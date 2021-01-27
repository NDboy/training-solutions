package lambdaintro;

import java.text.Collator;
import java.util.*;
import java.util.function.Function;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccounts);
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> accountsCopy = new ArrayList<>(bankAccounts);
        accountsCopy.sort(Comparator.naturalOrder());
        return accountsCopy;
    }


    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> accountsCopy = new ArrayList<>(bankAccounts);
        accountsCopy.sort(Comparator.comparing((a) -> Math.abs(a.getBalance())));
        return accountsCopy;
    }


    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> accountsCopy = new ArrayList<>(bankAccounts);
        accountsCopy.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return accountsCopy;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> accountsCopy = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        accountsCopy.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator)).thenComparing(BankAccount::getAccountNumber));
        return accountsCopy;
    }
}
