package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.SQLException;
import java.util.Scanner;

public class VaccinationManager {
    public static void main(String[] args) {

        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        VaccinationDao dao = new VaccinationDao(dataSource);
        Scanner scanner = new Scanner(System.in);
        int menu;
        do {
            System.out.println("\n\n1. Registration\n" +
                    "2. Multiple registration from file\n" +
                    "3. Generate list for invitation\n" +
                    "4. Vaccination\n" +
                    "5. Vaccination failure\n" +
                    "6. Generate report\n" +
                    "x. Escape");

            menu = scanner.nextInt();
            scanner.nextLine();
            if (menu == 1) {
                System.out.println("\n1. Registration:\nEnter the name!");
                String name = scanner.nextLine();
                while (!RegistryValidator.validateName(name)){
                    name = scanner.nextLine();
                }
                System.out.println("\n1. Registration:\nEnter the zip code!");
                int zip = scanner.nextInt();
                while (!RegistryValidator.validateZipCode(zip)) {
                    zip = scanner.nextInt();
                }
                dao.selectAndPrintLineCityByZipCode(zip);
                scanner.nextLine();
                System.out.println("\n1. Registration:\nEnter the age!");
                int age = scanner.nextInt();
                while (!RegistryValidator.validateAge(age)) {
                    age = scanner.nextInt();
                }
                scanner.nextLine();
                System.out.println("\n1. Registration:\nEnter the e-mail!");
                String email = scanner.nextLine();
                while (!RegistryValidator.validateEmail(email)) {
                    email = scanner.nextLine();
                }
                System.out.println("\n" + email + " 1. Registration:\nEnter the e-mail once again!");
                String email2 = scanner.nextLine();
                while (!RegistryValidator.parseTwoEmails(email, email2)) {
                    email2 = scanner.nextLine();
                }
                System.out.println("\n1. Registration:\nEnter the SSN!");
                long ssn = scanner.nextLong();
                while (!RegistryValidator.validateSsn(ssn)) {
                    ssn = scanner.nextLong();
                }
                int row = dao.selectCountCitizensTableRecords();
                dao.registerCitizen(new Citizen(name, new ZipCode(zip), age, email, ssn));
                int row2 = dao.selectCountCitizensTableRecords();
                if (row2 - row == 1) {
                    System.out.println("\n Successful registration! 1 citizen registered.");
                }
                scanner.nextLine();
            } else if (menu == 2) {
                System.out.println("\n2. Multiple registration from file:\n Enter the file path!");
                String pathString = scanner.nextLine();
                int row = dao.selectCountCitizensTableRecords();
                dao.registerCitizensFromFile(pathString);
                int row2 = dao.selectCountCitizensTableRecords();
                int diff = row2 - row;
                if (diff > 0) {
                    System.out.println("\nSuccessful registration! " + diff + " citizen(s) registered.\nC:/training/training-solutions/training-solutions/citizens.csv");
                }
            } else if (menu == 3) {
                System.out.println("\n3. Generate list for invitation:\nEnter the zip code!");
                int zip = scanner.nextInt();
                while (!RegistryValidator.validateZipCode(zip)) {
                    zip = scanner.nextInt();
                }
                int recordsFound = dao.selectCountCitizensTableRecordsByZip(zip);
                scanner.nextLine();
                if (recordsFound > 0) {
                    System.out.println("\n3. Generate list for invitation:\n" + recordsFound + " citizen(s) found.\nEnter the file path!");
                    String pathString = scanner.nextLine();
                    dao.generateFileWith16Citizens(zip, pathString);
                } else {
                    System.out.println("\n" + recordsFound + " citizen found with " + zip + " zip code.(Non or once vaccinated)\nGeneration failed!");
                }
            } else if (menu == 4) {
                System.out.println("\n4. Vaccination:\nEnter the SSN!");
                long ssn = scanner.nextLong();
                while (!RegistryValidator.validateSsn(ssn)) {
                    ssn = scanner.nextLong();
                }
                scanner.nextLine();
                dao.printLineMessagesDependingOnVaccinationNumberAndSaveVaccination(ssn);
            } else if (menu == 5) {
                System.out.println("\n5. Vaccination failure:\nEnter the SSN!");
                long ssn = scanner.nextLong();
                while (!RegistryValidator.validateSsn(ssn)) {
                    ssn = scanner.nextLong();
                }
                scanner.nextLine();
                System.out.println("\n5. Vaccination failure:\nEnter the reason of failure! (REJECTED, UNSUITABLE)");
                String statusString = scanner.nextLine();
                while (!RegistryValidator.validateStatus(statusString)) {
                    statusString = scanner.nextLine();
                }
                System.out.println("\n5. Vaccination failure:\nEnter note!");
                String noteString = scanner.nextLine();
                dao.saveVaccinationFailure(ssn, Status.valueOf(statusString), noteString);
            }
            else if (menu == 6) {
                dao.createReport();
            }
        } while (menu < 7);
        System.out.println("G A M E   O V E R");
    }
}
