package activitytracker;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
}
