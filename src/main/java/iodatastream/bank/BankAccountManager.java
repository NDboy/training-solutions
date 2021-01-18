package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {


    public void saveAccount(BankAccount account, Path folder) {

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                Files.newOutputStream(folder.resolve(account.getAccountNumber() + ".dat"))))){
            dos.writeUTF(account.getAccountNumber());
            dos.writeUTF(account.getOwner());
            dos.writeDouble(account.getBalance());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }

    }

    public BankAccount loadAccount(InputStream is) {
        BankAccount bankAccount;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is))){
            String accountNumber = dis.readUTF();
            String owner = dis.readUTF();
            double balance = dis.readDouble();
            bankAccount = new BankAccount(accountNumber, owner, balance);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return bankAccount;
    }
}
