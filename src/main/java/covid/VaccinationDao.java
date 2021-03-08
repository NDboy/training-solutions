package covid;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VaccinationDao {

    private final DataSource dataSource;

    public VaccinationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ZipCode selectAndPrintLineCityByZipCode(int zipCode) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select city from zip_codes where zipcode = ?")) {
            stmt.setInt(1, zipCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String cityName = rs.getString("city");
                    System.out.println(cityName);
                    return new ZipCode(zipCode, cityName);
                }
            }
        } catch (SQLException se) {
                throw new IllegalStateException("Connection failed", se);
        }
        System.out.println("No city with this zip code");
        return null;
    }


    public void registerCitizen(Citizen citizen) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("insert into citizens(citizen_name, zip, age, email, ssn) VALUES (?,?,?,?,?)")){
            stmt.setString(1, citizen.getName());
            stmt.setInt(2, citizen.getZipCode().getCode());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setLong(5, citizen.getSsn());
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert citizen", se);
        }
    }

    public void registerCitizensFromFile(String pathString) {
        Path path = Path.of(pathString);
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            br.readLine();
            try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("insert into citizens(citizen_name, zip, age, email, ssn) VALUES (?,?,?,?,?)")) {
                while ((line = br.readLine()) != null) {
                    setPreparedStatementWithParsedLine(stmt, line);
                }
            }
            catch (SQLException se) {
                throw new IllegalStateException("Connection failed", se);
            }
        }
        catch (IOException ioe) {
            System.out.println("The file path does not exist!");
        }
    }

    public int selectCountCitizensTableRecords() {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("SELECT COUNT(*) FROM citizens")) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        return 0;
    }

    public int selectCountCitizensTableRecordsByZip(int zip) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("SELECT COUNT(*) FROM citizens WHERE zip = ? AND number_of_vaccination < 2")) {
            stmt.setInt(1, zip);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        return 0;
    }

    private void setPreparedStatementWithParsedLine (PreparedStatement stmt, String line) {
        String[] lineArray = line.split(";");
        try {
            stmt.setString(1, lineArray[0]);
            stmt.setInt(2, Integer.parseInt(lineArray[1]));
            stmt.setInt(3, Integer.parseInt(lineArray[2]));
            stmt.setString(4, lineArray[3]);
            stmt.setLong(5, Integer.parseInt(lineArray[4]));
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not set statement", se);
        }
    }

    public void generateFileWith16Citizens(int zipCode, String pathString) {
        Path path = Path.of(pathString);
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám \n");
            fillTheFile(bw, zipCode);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
        System.out.println("\nSuccessful generating!\nC:/training/training-solutions/training-solutions/" + pathString);
    }

    private void fillTheFile(BufferedWriter bufferedWriter, int zipCode) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "select citizen_name, zip, age, email, ssn from citizens where zip = ? " +
                        "AND (number_of_vaccination = 0 or (number_of_vaccination < ? AND last_vaccination < (select CURDATE() - INTERVAL ? DAY))) ORDER BY age DESC LIMIT 16")){
            stmt.setInt(1, zipCode);
            stmt.setInt(2, 2);
            stmt.setInt(3, 15);
            try (ResultSet resultSet = stmt.executeQuery()){
                makeRowFromResultSetToBufferedWriter(bufferedWriter, resultSet);
            }

        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
    }

    private void makeRowFromResultSetToBufferedWriter(BufferedWriter bw, ResultSet rs) throws SQLException{
        StringBuilder sb = new StringBuilder();
        LocalTime time = LocalTime.of(8,0);
        while (rs.next()){
            sb.append(time + ";");
            time = time.plusMinutes(30);
            sb.append(rs.getString(1) + ";");
            sb.append(rs.getInt(2) + ";");
            sb.append(rs.getInt(3) + ";");
            sb.append(rs.getString(4) + ";");
            sb.append(rs.getLong(5) + "\n");
        }
        try {
            bw.write(sb.toString());
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public int selectNumberOfVaccinationBySsn(long ssn) {
        if (RegistryValidator.validateSsn(ssn)) {
            Citizen citizen = selectCitizenBySsn(ssn);
            if (citizen != null) {
                return citizen.getNumberOfVaccination();
            }
            System.out.println("\n4. Vaccination:\nCitizen not registered");
        }
        return -1;
    }

    public Citizen selectCitizenBySsn(long ssn) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from citizens where ssn = ?")) {
            stmt.setLong(1, ssn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("citizen_id");
                    String name = rs.getString("citizen_name");
                    int vaccNumber = rs.getInt("number_of_vaccination");
                    LocalDateTime dateTime = rs.getObject("last_vaccination", LocalDateTime.class);
                    return new Citizen(id, name, ssn, vaccNumber, dateTime);
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        return null;
    }

    public void printLineMessagesDependingOnVaccinationNumberAndSaveVaccination(long ssn) {
        int numberOfVaccination = selectNumberOfVaccinationBySsn(ssn);
        Scanner scanner = new Scanner(System.in);
        if (numberOfVaccination == 0) {
            System.out.println("\n4. Vaccination:\nEnter the date of vaccination! (Suitable format: yyyy-MM-dd hh:mm)");
            String dateTimeString = scanner.nextLine();
            System.out.println("\n4. Vaccination:\nEnter the type of vaccine! (PFIZER, MODERNA, ASTRAZENECA, SINOPHARM, SZPUTNYIK_V)");
            String vaccTypeString = scanner.nextLine();
            saveVaccination(ssn, dateTimeString, vaccTypeString);
            updateCitizenWithVaccination(ssn, dateTimeString, numberOfVaccination);
            System.out.println("\nSuccessful recording.");
        } else if (numberOfVaccination == 1) {
            Citizen citizen = selectCitizenBySsn(ssn);
            LocalDateTime dateTime = citizen.getLastVaccDateTime();
            Vaccination vaccination = selectVaccinationBySsn(ssn);
            System.out.println(String.format("%n4. Vaccination:%n Date of previous vaccination: %s,%n type of previous vaccination: %s.%n Enter the date of actual vaccination! (Suitable format: yyyy-MM-dd hh:mm)",
                    dateTime.toString(), vaccination.getVaccinationType().toString()));
            String actualDateTimeString = scanner.nextLine();
            saveVaccination(ssn, actualDateTimeString, vaccination.getVaccinationType().toString());
            updateCitizenWithVaccination(ssn, actualDateTimeString, numberOfVaccination);
            System.out.println("\nSuccessful recording.");
        } else if (numberOfVaccination == 2) {
            System.out.println("\n4. Vaccination:\nThe citizen is vaccinated twice!");
        }
    }

    public void saveVaccinationFailure(long ssn, Status status, String reasonOfFailure) {
        Scanner scanner = new Scanner(System.in);
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "insert into vaccinations(citizen_id, vaccination_date, status, note) VALUES (?,?,?,?)")){
            stmt.setInt(1, citizenId);
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(3, status.toString());
            stmt.setString(4, reasonOfFailure);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert vaccination", se);
        }
        System.out.println("\nSuccessful recording.");
    }

    public Vaccination selectVaccinationBySsn(long ssn) {
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from vaccinations where citizen_id = ?")) {
            stmt.setInt(1, citizenId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    LocalDateTime dateTime = rs.getObject("vaccination_date", LocalDateTime.class);
                    Status status = Status.valueOf(rs.getString("status"));
                    VaccinationType vaccType = VaccinationType.valueOf(rs.getString("vaccination_type"));
                    return new Vaccination(citizenId, dateTime, status, vaccType);
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        return null;
    }

    public void saveVaccination(long ssn, String dateTimeString, String vaccinationTypeString) {
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();

        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "insert into vaccinations(citizen_id, vaccination_date, status, vaccination_type) VALUES (?,?,?,?)")){
            stmt.setInt(1, citizenId);
            stmt.setTimestamp(2, Timestamp.valueOf(parseDateTime(dateTimeString)));
            stmt.setString(3, setStatusBySsn(ssn));
            stmt.setString(4, vaccinationTypeString);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert citizen", se);
        }
    }

    private String setStatusBySsn(long ssn) {
        int vaccNum = selectNumberOfVaccinationBySsn(ssn);
        if(vaccNum == 0) {
            return "FIRST";
        }
        if (vaccNum == 1) {
            return "SECOND";
        }
        return null;

    }

    private LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTimeString, dtf);
    }


//    private void updateCitizenWithVaccination(long ssn, String dateTimeString, int numberOfVaccination) {
//        Citizen citizen = selectCitizenBySsn(ssn);
//        int citizenId = 0;
//        if (citizen != null) citizenId = citizen.getId();
//
//        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
//                "UPDATE citizens SET number_of_vaccination = ?, last_vaccination = ? WHERE citizen_id = ?")){
//            stmt.setInt(1,  numberOfVaccination + 1);
//            stmt.setTimestamp(2, Timestamp.valueOf(parseDateTime(dateTimeString)));
//            stmt.setInt(3, citizenId);
//            stmt.executeUpdate();
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Can not insert citizen", se);
//        }
//    }

    private void updateCitizenWithVaccination(long ssn, String dateTimeString, int numberOfVaccination) {
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();

        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "SELECT citizen_id, number_of_vaccination, last_vaccination from citizens WHERE citizen_id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            stmt.setInt(1, citizenId);
            try ( ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    rs.updateInt(2, numberOfVaccination + 1);
                    rs.updateTimestamp(3, Timestamp.valueOf(parseDateTime(dateTimeString)));
                    rs.updateRow();
                }
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert citizen", se);
        }
    }

    public void createReport() {
        Path path = Path.of("report.csv");
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            bw.write("Irányítószám;Város;Beoltatlanok_száma;Egyszer_oltottak_száma;Kétszer_oltottak_száma" + "\n");
            fillTheFileWithResultSet(bw);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
        System.out.println("\n6. Generate report:\nSuccessful report generating:\nC:/training/training-solutions/training-solutions/report.csv");
    }

    private void fillTheFileWithResultSet(BufferedWriter bufferedWriter) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "SELECT citizens.zip AS c_zip, zip_codes.city, " +
                        "(select COUNT(*) FROM citizens where citizens.zip = c_zip and number_of_vaccination = 0) AS vaccinated_0, " +
                        "(select COUNT(*) FROM citizens where citizens.zip = c_zip and number_of_vaccination = 1) AS vaccinated_1, " +
                        "(select COUNT(*) FROM citizens where citizens.zip = c_zip and number_of_vaccination = 2) AS vaccinated_2 " +
                        "FROM citizens JOIN zip_codes ON citizens.zip = zip_codes.zipcode GROUP BY zip;")){
            try (ResultSet resultSet = stmt.executeQuery()){
                makeRowFromResultSetToReport(bufferedWriter, resultSet);
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
    }

    private void makeRowFromResultSetToReport(BufferedWriter bw, ResultSet rs) throws SQLException{
        StringBuilder sb = new StringBuilder();
        while (rs.next()){
            sb.append(rs.getInt(1) + ";");
            sb.append(rs.getString(2) + ";");
            sb.append(rs.getInt(3) + ";");
            sb.append(rs.getInt(4) + ";");
            sb.append(rs.getInt(5) + "\n");
        }
        try {
            bw.write(sb.toString());
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }


}
