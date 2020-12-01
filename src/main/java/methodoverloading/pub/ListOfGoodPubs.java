package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {
    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub betterPub = null;
        for (Pub pub: goodPubs) {
            if (betterPub == null || pub.getOpenFrom().isEarlier(betterPub.getOpenFrom())) {
                betterPub = pub;
            }
        }
        return betterPub;
    }

}
