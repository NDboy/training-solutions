package catalog;

import java.util.ArrayList;

import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> composer,  List<String> performers) {
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        if(Validators.isBlank(title) || length <= 0 || Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Invalid argument");
        }
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>(performers);
        if (composer != null) {
            for (String comp : composer) {
                result.add(comp);
            }
        }
        return result;
    }
}
