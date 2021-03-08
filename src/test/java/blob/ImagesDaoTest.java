package blob;

import covid.Citizen;
import covid.VaccinationDao;
import covid.ZipCode;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ImagesDaoTest {

    MariaDbDataSource dataSource;
    ImagesDao imagesDao;

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


//        Flyway flyway = Flyway.configure().locations("/db/migration/covid").dataSource(dataSource).load();
//        flyway.clean();
//        flyway.migrate();

        imagesDao = new ImagesDao(dataSource);
    }

    @Test
    void testSaveImage() {
        imagesDao.saveImage("img.png", ImagesDaoTest.class.getResourceAsStream("/img.png"));
    }

}