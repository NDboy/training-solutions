package inheritanceconstructor.classroom;

public class ClassRoom extends Room{
    private Facility facility;

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public Facility getFacility() {
        return facility;
    }

    public boolean isSuitable(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if(course.getParticipants() <= getCapacity() &&
           course.getFacilityNeeded() == getFacility()) {
            return true;
        }
        return false;
    }



}
