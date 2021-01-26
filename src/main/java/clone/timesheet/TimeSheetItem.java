package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        this.employee = timeSheetItem.employee;
        this.project = timeSheetItem.project;
        this.from = timeSheetItem.from;
        this.to = timeSheetItem.to;
    }

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate) {
        TimeSheetItem timeSheetCopy = new TimeSheetItem(timeSheetItem);
        LocalDateTime newFrom = LocalDateTime.of(localDate, timeSheetCopy.getFrom().toLocalTime());
        LocalDateTime newTo = LocalDateTime.of(localDate, timeSheetCopy.getTo().toLocalTime());
        return new TimeSheetItem(timeSheetCopy.employee, timeSheetCopy.project, newFrom, newTo);
    }
}
