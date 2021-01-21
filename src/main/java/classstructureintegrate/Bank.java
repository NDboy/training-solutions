package classstructureintegrate;

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("12344567-32114561-32147896", "John Doe", 1000000);
        BankAccount bankAccount2 = new BankAccount("12348467-85414561-84947896", "Jack Doe", 2000000);

        bankAccount1.deposit(50000);
        bankAccount1.withdraw(60000);
        bankAccount2.deposit(70000);
        bankAccount2.withdraw(80000);

        System.out.println(bankAccount1.getInfo());
        System.out.println(bankAccount2.getInfo());

        bankAccount1.transfer(bankAccount2, 200000);

        System.out.println(bankAccount1.getInfo());
        System.out.println(bankAccount2.getInfo());

        bankAccount2.transfer(bankAccount1, 400000);

        System.out.println(bankAccount1.getInfo());
        System.out.println(bankAccount2.getInfo());
    }
}
