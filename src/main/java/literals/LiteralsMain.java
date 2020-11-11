package literals;

public class LiteralsMain {
    public static void main(String[] args) {

        System.out.println(1 + "2");
        System.out.println("1" + "2");
        double quotient = 3d / 4d;
        System.out.println(quotient);
        long big = 3_244_444_444l;
        System.out.println(big);
        String s = "árvíztűrőtükörfúrógép";
        System.out.println(s);
        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1) + "\n" + Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-5));

//        System.out.println(new Integer(1) + new Integer(2));



    }
}
