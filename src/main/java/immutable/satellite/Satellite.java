package immutable.satellite;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private final String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public boolean isEmpty(String a) {
        return a == null || "".equals(a);
    }


    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        int x = destinationCoordinates.getX() + diff.getX();
        int y = destinationCoordinates.getY() + diff.getY();
        int z = destinationCoordinates.getZ() + diff.getZ();
        destinationCoordinates = new CelestialCoordinates(x, y, z);
    }

    @Override
    public String toString() {
        return registerIdent + ": " + destinationCoordinates;
    }
}
