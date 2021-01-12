package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList/* = new ArrayList<>()*/;

    public TransactionManager() {
        this.accountList = new ArrayList<>();
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String pathString) {
        Path path = Path.of(pathString);
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
            for(String line: lines) {
                BankAccount bankAccount = new BankAccount(line.split(";")[0], line.split(";")[1], Integer.parseInt(line.split(";")[2]));
                accountList.add(bankAccount);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void makeTransactions(String pathString) {
        Path path = Path.of(pathString);
        List<Transaction> transactions = new ArrayList<>();
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
            for(String line: lines) {
                Transaction transaction = new Transaction(line.split(";")[0], Integer.parseInt(line.split(";")[1]));
                transactions.add(transaction);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        for (BankAccount bankAccount: accountList) {
            for (Transaction transaction: transactions) {
                if (bankAccount.getAccountNumber().equals(transaction.getAccountNumber())) {
                    bankAccount.setBalance(transaction.getAmount());
                }
            }
        }
    }
}
