package abstractclass.gamecharacter;

public class Point {
    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point point2) {
        return (long) Math.sqrt(Math.pow(((double)x - point2.getX()), 2) + Math.pow(((double)y - point2.getY()), 2));
    }

}
