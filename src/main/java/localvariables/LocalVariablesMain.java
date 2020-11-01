package localvariables;

import static java.lang.System.*;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b = false;
        out.println(b);

        int a = 2;
        int i = 3;
        int j = 4;
        int k;
        k = i;
        out.println(a);
        for (int i1 : new int[]{i, j, k}) {
            out.println(i1);
        }
        String s = "Hello World!";
        String t = s;


        out.println(t);



    }

}
