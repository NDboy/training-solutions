package activitytracker;

import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("insert into activities(start_time, activity_desc, activity_type) VALUES (?,?,?)")){
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().getValue());
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    public List<Activity> selectActivityBeforeDate(LocalDate date){
        List<Activity> result = new ArrayList<>();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from activities where start_time < ?")){
            stmt.setTimestamp(1, Timestamp.valueOf(date.atTime(LocalTime.MIN)));
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
                    String description = resultSet.getString("activity_desc");
                    ActivityType type = ActivityType.valueOf(resultSet.getString("activity_type").toUpperCase());
                    result.add(new Activity(id, startTime, description, type));
                }
            }
            catch (SQLException se) {
                throw new IllegalStateException("Can not query", se);
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
        return result;
    }

    public List<Activity> selectActivityBeforeDate2(LocalDate date){
        List<Activity> result = new ArrayList<>();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from activities where start_time < ?")){
            stmt.setTimestamp(1, Timestamp.valueOf(date.atTime(LocalTime.MIN)));
            return selectAllRecordsByPreparedStatement(stmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    public Activity saveActivityAndReturnWithGeneratedId(Activity activity) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("insert into activities(start_time, activity_desc, activity_type) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().getValue());
            stmt.executeUpdate();
            return getActivityByStatement(activity, stmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    private Activity getActivityByStatement(Activity activity, PreparedStatement stmt){
        try (ResultSet rs = stmt.getGeneratedKeys()){
            if (rs.next()) {
                return new Activity(activity, rs.getLong(1));
            }
            throw new IllegalStateException("Cannot get id");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot get id", se);
        }
    }

    public Activity findActivityById(long id) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from activities where id = ?")){
            stmt.setLong(1, id);
            return selectRecordByPreparedStatement(stmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    private Activity selectRecordByPreparedStatement(PreparedStatement ps) {
        try (ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
                String description = resultSet.getString("activity_desc");
                ActivityType type = ActivityType.valueOf(resultSet.getString("activity_type").toUpperCase());

                return new Activity(id, startTime, description, type);
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not query", se);
        }
        throw new IllegalArgumentException("No record found");
    }

    public List<Activity> listActivities() {
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from activities")){
            return selectAllRecordsByPreparedStatement(ps);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    private List<Activity> selectAllRecordsByPreparedStatement(PreparedStatement ps) {
        List<Activity> activityList = new ArrayList<>();
        try (ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
                String description = resultSet.getString("activity_desc");
                ActivityType type = ActivityType.valueOf(resultSet.getString("activity_type").toUpperCase());
                activityList.add(new Activity(id, startTime, description, type));
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not query", se);
        }
        return activityList;
    }

    public void saveActivityWithTrackPoints(Activity activity) {
        Long id = 0L;
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)){
                stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                stmt.setString(2, activity.getDesc());
                stmt.setString(3, activity.getType().getValue());
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()){
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }

                } catch (SQLException se) {
                    throw new IllegalStateException("Cannot get id", se);
                }
            } catch (SQLException se) {
                throw new IllegalStateException("Connection failed");
            }
            try (PreparedStatement stmt2 = conn.prepareStatement("insert into track_points(activity_id, track_time, latitude, longitude) VALUES (?,?,?,?)")){
                for (TrackPoint trackPoint: activity.getTrackPoints()){
                    stmt2.setLong(1, id);
                    stmt2.setTimestamp(2, Timestamp.valueOf(trackPoint.getTime()));
                    stmt2.setDouble(3, trackPoint.getLat());
                    stmt2.setDouble(4, trackPoint.getLon());
                    stmt2.executeUpdate();
                }
                conn.commit();
            } catch (SQLException se) {
                conn.rollback();
                throw new IllegalStateException("Connection failed");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    public Activity findActivityByIdWithTrackPoints(long id) {
        Activity activity = null;
        try (Connection conn = dataSource.getConnection()) {
//            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?")){
                stmt.setLong(1, id);
                activity = selectRecordByPreparedStatement(stmt);
            }
            try (PreparedStatement stmt2 = conn.prepareStatement("select * from track_points where activity_id = ?")){
                stmt2.setLong(1, id);
                return selectTrackPointRecordsAndCreateNewActivityByPreparedStatement(stmt2, activity/*, id*/);
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Connection failed");
        }
    }

    private Activity selectTrackPointRecordsAndCreateNewActivityByPreparedStatement(PreparedStatement stmt, Activity activity/*, long activityId*/) {
        List<TrackPoint> trackPoints = new ArrayList<>();

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    long activityId = resultSet.getLong("activity_id");
                    LocalDateTime trackTime = resultSet.getTimestamp("track_time").toLocalDateTime();
                    double latitude = resultSet.getDouble("latitude");
                    double longitude = resultSet.getDouble("longitude");
                    trackPoints.add(new TrackPoint(id, activityId, trackTime, latitude, longitude));
                }
                return new Activity(activity, trackPoints);
            }
            catch (SQLException se) {
                throw new IllegalStateException("Can not query", se);
            }

    }
}
