package classstructureconstructors;


public class BookMain {
    public static void main(String[] args) {

        Book book = new Book("Anthony Doerr", "A láthatatlan fény");
        book.register("054");

        System.out.println(book.getAuthor());
        System.out.println(book.getTitle());
        System.out.println(book.getRegNumber());
    }

}
