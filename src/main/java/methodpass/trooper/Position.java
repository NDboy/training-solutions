package methodpass.trooper;

public class Position {
    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        return Math.sqrt(Math.pow((getPosX() - position.getPosX()), 2) + Math.pow((getPosY() - position.getPosY()), 2));
    }

}
