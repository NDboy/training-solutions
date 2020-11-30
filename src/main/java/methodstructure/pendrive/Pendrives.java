package methodstructure.pendrive;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive better = null;
        for (Pendrive pendrive: pendrives) {
            if (better == null || better.comparePricePerCapacity(pendrive) == 1) {
                better = pendrive;
            }
        }
        return better;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive cheaper = null;
        for (Pendrive pendrive: pendrives) {
            if (cheaper == null || pendrive.cheaperThan(cheaper)) {
                cheaper = pendrive;
            }
        }
        return cheaper;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive pendrive: pendrives) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }


}
