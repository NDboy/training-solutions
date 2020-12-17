package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {
    private List<Feature> features = new ArrayList<>();
    private Feature feature;
    private int price;
    private String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.features = List.of(features);
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public Feature getFeature() {
        return feature;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int fullLengthAtOneItem() {
        int lengthSum = 0;
        for (Feature feature: features) {
            if (feature instanceof AudioFeatures) {
                lengthSum += ((AudioFeatures) feature).getLength();
            }
        }
        return lengthSum;
    }

    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        for (Feature feature : features) {
            result.addAll(feature.getContributors());
        }
        return result;
    }

    public List<String> getTitles() {
        List<String> result = new ArrayList<>();
        for (Feature feature : features) {
            result.add(feature.getTitle());
        }
        return result;
    }

    public boolean hasAudioFeature() {
        boolean isTrue = false;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    public boolean hasPrintedFeature() {
        boolean isTrue = false;
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    public int numberOfPagesAtOneItem() {
        int lengthSum = 0;
        for (Feature feature: features) {
            if (feature instanceof PrintedFeatures) {
                lengthSum += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return lengthSum;
    }


}
