package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    MariaDbDataSource dataSource;
    List<Activity> activityList;
    ActivityDao activityDao;
    List<TrackPoint> trackPointList;
    Activity activity1;
    Activity activity2;

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

        trackPointList = new ArrayList<>();
        trackPointList.add(new TrackPoint(LocalDateTime.of(2020, 10, 10, 10,10), 40.0,50.0));
        trackPointList.add(new TrackPoint(LocalDateTime.of(2020, 10, 10, 10,15), 40.1,49.9));
        trackPointList.add(new TrackPoint(LocalDateTime.of(2020, 10, 10, 10,20), 40.2,49.8));

        activity1 = new Activity(LocalDateTime.of(2020, 10, 10, 10,10), "Running in the forest", ActivityType.RUNNING, trackPointList);
        activity2 = new Activity(LocalDateTime.of(2020, 11, 11, 11,11), "Biking in the forest", ActivityType.BIKING, trackPointList);

        Flyway flyway = Flyway.configure().locations("/db/migration/activitytracker").dataSource(dataSource).load();
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
        assertEquals("4 2021-01-01T01:01 Hiking in the forest HIKING []", activityDao.listActivities().get(3).toString());
    }

    @Test
    void testFindActivityById() {
        for (Activity activity: activityList) {
            activityDao.saveActivity(activity);
        }
        assertEquals("3 2020-12-12T12:12 Playing basketball in the forest BASKETBALL []", activityDao.findActivityById(3).toString());
    }

    @Test
    void testSaveAndListAndWithId() {
        List<Long> idList = new ArrayList<>();
        for (Activity activity: activityList) {
            Activity activityWithId = activityDao.saveActivityAndReturnWithGeneratedId(activity);
            idList.add(activityWithId.getId());
        }
        assertEquals(Arrays.asList(1L,2L,3L,4L), idList);
    }

    @Test
    void testSelectBeforeDate() {
        for (Activity activity: activityList) {
            activityDao.saveActivity(activity);
        }
        assertEquals(2, activityDao.selectActivityBeforeDate(LocalDate.of(2020, 12, 1)).size());
        assertEquals(1, activityDao.selectActivityBeforeDate2(LocalDate.of(2020, 11, 1)).size());
    }

    @Test
    void testSaveActivityWithTrackPoints() {
        activityDao.saveActivityWithTrackPoints(activity1);
        activityDao.saveActivityWithTrackPoints(activity2);
        assertEquals(3, activityDao.findActivityByIdWithTrackPoints(1).getTrackPoints().size());
        assertEquals(3, activityDao.findActivityByIdWithTrackPoints(2).getTrackPoints().size());
        assertEquals("id= 6, activityId= 2, time= 2020-10-10T10:20, lat= 40.2, lon= 49.8", activityDao.findActivityByIdWithTrackPoints(2).getTrackPoints().get(2).toString());
    }
}