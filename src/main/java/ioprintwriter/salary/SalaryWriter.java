package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path path) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path))){
            for (String name: names) {
                pw.print(name);
                pw.print(": ");
                if (name.startsWith("Dr")) {
                    pw.println(500000);
                } else if (name.startsWith("Mr") || name.startsWith("Mrs")) {
                    pw.println(200000);
                } else {
                    pw.println(100000);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

}
