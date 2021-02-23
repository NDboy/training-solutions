package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    MariaDbDataSource dataSource;
    List<Activity> activityList;
    ActivityDao activityDao;

    @BeforeEach
    public void init() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        activityList = new ArrayList<>();
        activityList.add(new Activity(LocalDateTime.of(2020, 10, 10, 10,10), "Running in the forest", ActivityType.RUNNING));
        activityList.add(new Activity(LocalDateTime.of(2020, 11, 11, 11,11), "Biking in the forest", ActivityType.BIKING));
        activityList.add(new Activity(LocalDateTime.of(2020, 12, 12, 12,12), "Playing basketball in the forest", ActivityType.BASKETBALL));
        activityList.add(new Activity(LocalDateTime.of(2021, 1, 1, 1,1), "Hiking in the forest", ActivityType.HIKING));

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    void testSaveAndListActivities() {
        for (Activity activity: activityList) {
            activityDao.saveActivity(activity);
        }
        assertEquals(4, activityDao.listActivities().size());
        assertEquals("4 2021-01-01T01:01 Hiking in the forest HIKING", activityDao.listActivities().get(3).toString());
    }

    @Test
    void testFindActivityById() {
        for (Activity activity: activityList) {
            activityDao.saveActivity(activity);
        }
        assertEquals("3 2020-12-12T12:12 Playing basketball in the forest BASKETBALL", activityDao.findActivityById(3).toString());
    }

}