package lambdacomparator.cloud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        List<CloudStorage> listToSort = new ArrayList<>(storages);
        listToSort.sort(Comparator.comparing(CloudStorage::getProvider, Comparator.comparing(String::toLowerCase)));
        return listToSort.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        List<CloudStorage> listToSort = new ArrayList<>(storages);

        listToSort.sort(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))).thenComparing(CloudStorage::getPrice));
        return listToSort.get(0);
    }


    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        List<CloudStorage> listToSort = new ArrayList<>(storages);
        listToSort.sort(Comparator.reverseOrder());
        if (listToSort.size() <= 3) {
            return listToSort;
        }

        return listToSort.subList(0,3);
    }


}
