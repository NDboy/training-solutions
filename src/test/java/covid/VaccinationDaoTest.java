package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationDaoTest {

    MariaDbDataSource dataSource;
    VaccinationDao vaccinationDao;
    Citizen citizen1 = new Citizen("John Doe", new ZipCode(6772), 62, "gh@gmail.com", 121212128);



    @BeforeEach
    public void init() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }


        Flyway flyway = Flyway.configure().locations("/db/migration/covid").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        vaccinationDao = new VaccinationDao(dataSource);
//        vaccinationDao.registerCitizensFromFile("citizens.csv");
        vaccinationDao.registerCitizen(citizen1);

    }

    @Test
    void testSelectCityByZipCode() {
        assertEquals("Deszk", vaccinationDao.selectAndPrintLineCityByZipCode(6772).getCity_name());
        assertNull(vaccinationDao.selectAndPrintLineCityByZipCode(9999));
        assertNull(vaccinationDao.selectAndPrintLineCityByZipCode(99991));
        assertEquals("Óbarok", vaccinationDao.selectAndPrintLineCityByZipCode(2063).getCity_name());
    }

    @Test
    void testRegisterCitizenAndFindBySsn() {
        vaccinationDao.registerCitizen(citizen1);
        assertTrue(RegistryValidator.validateSsn(121212128));
        assertEquals("John Doe", vaccinationDao.selectCitizenBySsn(121212128L).getName());
        vaccinationDao.registerCitizensFromFile("citizens.csv");
        assertEquals("Errol Melly", vaccinationDao.selectCitizenBySsn(698093618).getName());

    }

    @Test
    void testGenerateFileWith16Citizens() {
        vaccinationDao.generateFileWith16Citizens(1500, "selectforinvite.txt");
//        vaccinationDao.printLineMessagesDependingOnVaccinationNumberAndSaveVaccination(121212128);
//        vaccinationDao.saveVaccinationFailure(121212128, Status.REJECTED, "Be van szarva!");
        vaccinationDao.saveVaccination(121212128, "2021-03-01 08:10", "MODERNA");
//        System.out.println(vaccinationDao.selectVaccinationBySsn(121212128));
//        vaccinationDao.updateCitizenWithVaccination(121212128, "2021-03-01 08:10", 1);
    }

    @Test
    void testCreateReport() {
        vaccinationDao.createReport();
    }

    @Test
    void testSelectNumberOfVaccinationBySsn() {
        vaccinationDao.registerCitizensFromFile("citizens.csv");
        assertEquals(0, vaccinationDao.selectNumberOfVaccinationBySsn(638420856));
        assertEquals(-1, vaccinationDao.selectNumberOfVaccinationBySsn(4545));

    }


}