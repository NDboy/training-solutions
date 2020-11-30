package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    private List<Satellite> satellites = new ArrayList<>();

    public SpaceAgency() {
        this.satellites = satellites;
    }

    public boolean isEmpty(String a) {
        return a == null || "".equals(a);
    }

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Argument must not be empty!");
        }
        Satellite foundSatellite = null;
        for (Satellite satellite : satellites) {
            if (registerIdent.equals(satellite.getRegisterIdent())) {
                foundSatellite = satellite;
            }
        }
        if (foundSatellite == null) {
            throw new IllegalArgumentException("Satellite with the given registration cannot be found!XXX123");
        }
        return foundSatellite;
    }

    @Override
    public String toString() {
        return satellites.toString();
    }
}
