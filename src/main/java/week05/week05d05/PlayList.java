package week05.week05d05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayList {

    private List<SongSenior> songs;

    public PlayList(List<SongSenior> songs) {
        this.songs = songs;
    }

//    public List<SongSenior> findByLengthGreaterThan(int mins) {
//        List<SongSenior> result = new ArrayList<>();
//        for (SongSenior song: songs) {
//            if ((double)(song.getLengthInSeconds()) / 60.0 > (double) mins) {
//                result.add(song);
//            }
//        }
//        return result;
//    }

    public List<SongSenior> findByLengthGreaterThan(int mins) {
        return songs.stream()
                .filter(a -> (double)(a.getLengthInSeconds()) / 60.0 > (double) mins)
                .collect(Collectors.toList());
    }

}
