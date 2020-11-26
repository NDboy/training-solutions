package week04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PractiseTest {
    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("John");
        sb.append(12.12);

        assertEquals(sb.toString(), "John12.12");
        sb.insert(4, " " + LocalDate.now() + " ");
        System.out.println(sb);
        System.out.println(sb.reverse());
        String s = sb.toString();

        String strN = "555";
        String strS = "nnn5";

        int n = Integer.parseInt(strN);
        int m = Integer.parseInt(strS);

        System.out.println(n);
//        System.out.println(m);



    }
}
