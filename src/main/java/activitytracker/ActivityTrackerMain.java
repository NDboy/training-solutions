package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {


//    public void insertValuesToTable(List<Activity> activities, MariaDbDataSource dataSource) {
//        try (
//                Connection conn = dataSource.getConnection();
//                PreparedStatement stmt = conn.prepareStatement("INSERT INTO activities(start_time, activity_desc, activity_type) VALUES (?,?,?)"))
//        {
//            for (Activity activity: activities) {
//                stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
//                stmt.setString(2, activity.getDesc());
//                stmt.setString(3, activity.getType().getValue());
//                stmt.executeUpdate();
//            }
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Can not insert", se);
//        }
//    }

//    private Activity selectRecordByPreparedStatement(PreparedStatement ps) {
//        try (ResultSet resultSet = ps.executeQuery()) {
//            if (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
//                String description = resultSet.getString("activity_desc");
//                ActivityType type = ActivityType.valueOf(resultSet.getString("activity_type").toUpperCase());
//
//                return new Activity(id, startTime, description, type);
//
//            }
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Can not query", se);
//        }
//        throw new IllegalArgumentException("No record found");
//    }

//    private List<Activity> selectRecordsByPreparedStatement(PreparedStatement ps) {
//        List<Activity> resultList = new ArrayList<>();
//        try (ResultSet resultSet = ps.executeQuery()) {
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
//                String description = resultSet.getString("activity_desc");
//                ActivityType type = ActivityType.valueOf(resultSet.getString("activity_type").toUpperCase());
//
//                resultList.add(new Activity(id, startTime, description, type));
//            }
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Can not query", se);
//        }
//        return resultList;
//    }

//    public Activity selectRecordById(MariaDbDataSource dataSource, int id) {
//        Activity result;
//        try (
//                Connection conn = dataSource.getConnection();
//                PreparedStatement ps = conn.prepareStatement("SELECT * from activities where id =?");
//                ){
//            ps.setInt(1, id);
//            result = selectRecordByPreparedStatement(ps);
//
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Can not make query", se);
//        }
//        return result;
//    }

//    public List<Activity> selectRecordsAndAddToList(MariaDbDataSource dataSource) {
//        List<Activity> resultList;
//        try (
//                Connection conn = dataSource.getConnection();
//                PreparedStatement ps = conn.prepareStatement("SELECT * from activities");
//        ){
//            resultList = selectRecordsByPreparedStatement(ps);
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Can not make query", se);
//        }
//        return resultList;
//    }




    public static void main(String[] args) {


    }
}
