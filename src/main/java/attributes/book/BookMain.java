package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("A láthatatlan fény");
        System.out.println(book.getTitle());
        book.setTitle("Krsna");
        System.out.println(book.getTitle());
    }
}
