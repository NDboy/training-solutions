package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        message = message + "444";
        System.out.println(message);
        boolean b = message.equals("Hello John Doe");
        System.out.println(b);
        boolean c = message.equals("Hello John Doe444");
        System.out.println(c);
        String k = "";
        String l = "";
        String m = k + l;

        System.out.println(m);
        System.out.println(m.length());

        String p = "Abcde";
        System.out.println(p.length());
        System.out.println(p.substring(0,1) + "," + p.substring(2,3));
        System.out.println(p.substring(0,3));


    }
}
