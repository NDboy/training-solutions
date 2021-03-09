package week05.week05d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    @Test
    void testFindByLengthGreaterThan() {
        List<SongSenior> songs = Arrays.asList(new SongSenior("John Doe", 90, "Happy 90"),
                new SongSenior("Jack Doe", 100, "Happy 100"),
                new SongSenior("Jane Doe", 125, "Happy 125"),
                new SongSenior("John Doe", 130, "Happy 130"));
        PlayList pl = new PlayList(songs);
        assertEquals(125, pl.findByLengthGreaterThan(2).get(0).getLengthInSeconds());
        assertEquals(2, pl.findByLengthGreaterThan(2).size());
        assertEquals(0, pl.findByLengthGreaterThan(3).size());
    }
}