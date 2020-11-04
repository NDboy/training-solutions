package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] week = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int[] arr = new int[5];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1]*2;
        }
        for (int a: arr) {
            System.out.println(a);
        }

        boolean[] arrayOfBooleans = new boolean[6];
        arrayOfBooleans[0] = false;

        for (int i = 1; i < arrayOfBooleans.length; i++) {
            arrayOfBooleans[i] = ! arrayOfBooleans[i-1];
        }

//        boolean[] arrayOfBooleans = {false, true, false, true, false, true};
        for (boolean b: arrayOfBooleans) {
            System.out.println(b);
        }



    }
}
