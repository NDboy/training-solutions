package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver (int page) {
        if (page <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        double sum = 0.0;
        int counter = 0;
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasPrintedFeature() && catalogItem.numberOfPagesAtOneItem() > page) {
                counter++;
                sum += catalogItem.numberOfPagesAtOneItem();

            }
        }
        if (counter == 0) {
            throw new IllegalArgumentException("No page");
        }
        return counter > 0 ? sum / (double) counter : 0.0;
    }

    public void deleteItemByRegistrationNumber(String str) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (str.equals(catalogItems.get(i).getRegistrationNumber())) {
                catalogItems.remove(i);
            }
        }
    }

    public List<CatalogItem> findByCriteria (SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature: catalogItem.getFeatures()) {
                if (feature.getTitle().equals(searchCriteria.getTitle()) || feature.getContributors().contains(searchCriteria.getContributor())) {
                    if (!result.contains(catalogItem)) {
                        result.add(catalogItem);
                    }
                }
            }
        }
        return result;
    }


    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                sum += catalogItem.numberOfPagesAtOneItem();
            }
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                result.add(catalogItem);
            }
        }
        return result;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                sum += catalogItem.fullLengthAtOneItem();
            }
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                result.add(catalogItem);
            }
        }
        return result;
    }


}
