package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{
    private String title;
    private int numberOfPages;
    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if(numberOfPages <= 0 || Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("Invalid argument");
        }
        if(Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
