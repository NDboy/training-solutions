package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    public void saveTransactions(Path zipPath, List<Transaction> transactionList) {
        try(ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(zipPath)))) {
            for (Transaction transaction: transactionList) {
                zos.putNextEntry(new ZipEntry(String.format("%d.txt", transaction.getId())));

                PrintStream pw = new PrintStream(zos);
                pw.println(transaction.getTime());
                pw.println(transaction.getAccount());
                pw.println(transaction.getAmount());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactionList = List.of(
                new Transaction(345L, LocalDateTime.of(2018, 2, 21, 12, 5, 31), "10092385-34562856-00008701", 412000.0),
                new Transaction(1297L, LocalDateTime.of(2018, 2, 21, 13, 10, 6), "10092385-23651299-00123013", -12000.0)
        );

        new TransactionFileManager().saveTransactions(Path.of("employee.zip"), transactionList);
    }

}
