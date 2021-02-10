package week15.week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {

    private List<Post> postList;

    public PostFinder(List<Post> postList) {
        this.postList = postList;
    }

    public List<Post> getPostList() {
        return new ArrayList<>(postList);
    }

    public List<Post> findPostsFor(String user) {
//        return postList.stream().filter(a -> a.getOwner().equals(user)).collect(Collectors.toList());
        return postList.stream().filter(a -> (a.getOwner().equals(user)
                                            && a.getPublishedAt().isBefore(LocalDate.now())
                                            && a.getContent() != null
                                            && !a.getContent().isBlank()
                                            && a.getTitle() != null)
                                            && !a.getTitle().isBlank())
                .collect(Collectors.toList());
    }

}

//    Implementáljunk a PostFinder osztályban egy public List<Post> findPostsFor(String user) metódust az alábbi módon:
//        - Csak olyan Post-ot adjunk vissza, amelynek az owner-e megegyezik a megadott user-rel
//        - A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
//        - A content és a title nem lehet üres
//        Tároljunk egy List<Post> objektumot a PostFinder osztályban, melyet konstruktor paraméterként kap meg és ezt használjuk! (edited)
