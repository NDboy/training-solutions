package statements;

public class StatementMain {
    public static void main(String[] args) {
        System.out.println("aa".equals("aa"));

        int x = 5 + 6;
        int y = 11 - x;
        int z = 8;
        boolean b = x > y;

        boolean c = (b) || (z > 5);

        System.out.println(c);

        System.out.println(++z);



    }
}
