package week05.week05d05;

public class SongSenior {
    private String name;
    private long lengthInSeconds;
    private String artist;

    public SongSenior(String name, long lengthInSeconds, String artist) {
        throwExceptionWithMessageIfStringEmpty(name, "Name must not be empty");
        throwExceptionWithMessageIfStringEmpty(artist, "Artist must not be empty");
        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException("The length must be positive");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    private void throwExceptionWithMessageIfStringEmpty(String str, String message) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return name + " " + lengthInSeconds + " " + artist;
    }
}
