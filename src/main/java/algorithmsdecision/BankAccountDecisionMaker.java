package algorithmsdecision;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> bankAccounts, int limit) {
        boolean isBalanceGreater = false;
        int i = 0;
        while (i < bankAccounts.size() && !isBalanceGreater) {
            if(bankAccounts.get(i).getBalance() > limit) {
                isBalanceGreater = true;
            }
            i++;
        }
        return isBalanceGreater;

    }

}
