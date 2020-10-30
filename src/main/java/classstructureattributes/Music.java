package classstructureattributes;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        song.band = "Wolfgang Amadeus Mozart";
        song.title = "41., C-dúr szimfónia";
        song.length = 40;

        System.out.println(song.band+ " - " +song.title + " ("+song.length + " perc" + ")");


    }
}
