package week15.week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void testFindPostsFor() {
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("alma", LocalDate.of(2000, 12, 12), "   ", "John Doe"));
        postList.add(new Post("barack", LocalDate.of(2001, 12, 12), "barack", "Jane Doe"));
        postList.add(new Post("banán", LocalDate.of(2002, 12, 12), "banán", "Jane Doe"));
        postList.add(new Post("szőlő", LocalDate.of(2003, 12, 12), "szőlő", "John Doe"));
        postList.add(new Post("narancs", LocalDate.of(2022, 12, 12), "narancs", "Jane Doe"));
        postList.add(new Post(" \n", LocalDate.of(2010, 12, 12), "eper", "John Doe"));
        postList.add(new Post("málna", LocalDate.of(2009, 12, 12), "málna", "Jane Doe"));
        postList.add(new Post(null, LocalDate.of(2009, 12, 12), "", "Jane Doe"));
        postList.add(new Post("vegyigyümi", LocalDate.of(2030, 12, 12), "vegyigyümi", "John Doe"));

        PostFinder postFinder = new PostFinder(postList);
        assertEquals(1, postFinder.findPostsFor("John Doe").size());
        assertEquals("szőlő", postFinder.findPostsFor("John Doe").get(0).getContent());
        assertEquals("szőlő", postFinder.findPostsFor("John Doe").get(0).getTitle());
        assertEquals("John Doe", postFinder.findPostsFor("John Doe").get(0).getOwner());
        assertEquals(LocalDate.of(2003,12,12), postFinder.findPostsFor("John Doe").get(0).getPublishedAt());
    }
}