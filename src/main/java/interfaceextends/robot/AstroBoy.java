package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot{
    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public static final long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    public void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }

    public void flyTo(Point position) {
        this.position = new Point(position.x, position.y, ALTITUDE);
        path.add(this.position);
    }

    @Override
    public void liftTo(long altitude) {
        this.position = new Point(position.x, position.y, altitude);
        path.add(position);
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        flyTo(position);
        this.position = new Point(position.x, position.y, 0);
        path.add(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }
}
