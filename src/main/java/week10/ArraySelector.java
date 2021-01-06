package week10;

public class ArraySelector {

    public String selectEvens(int [] numbers) {
        if (numbers.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0 || i % 2 == 0) {
                sb.append(numbers[i] + ", ");
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

}

//    Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között!
//
//        A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
//
//        Ha nulla elemű a tömb, akkor üres stringet adjon vissza!