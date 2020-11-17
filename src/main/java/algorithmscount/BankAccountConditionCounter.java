package algorithmscount;

import java.util.List;

public class BankAccountConditionCounter {

    public int accountCounterByBalance(List<BankAccount> bankAccounts, int limit) {
        int counter = 0;
        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getBalance() > limit) {
                counter++;
            }
        }
        return counter;
    }
}
