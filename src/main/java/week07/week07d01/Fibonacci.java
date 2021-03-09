package week07.week07d01;

public class Fibonacci {

    public static long fib(int n) {
        long result = 0;
        long puffer;
        long puffer2 = 1;
        if (n == 1) {
            result = 1;
        } else if (n > 1){
            for (int i = 0; i < n; i++) {
                puffer = result;
                result = puffer + puffer2;
                puffer2 = puffer;
            }
        }
        return result;
    }


//    0  1  1  2  3  5  8  13  21  34

//    0  1  2  3  4  5  6  7   8   9


    public static void main(String[] args) {
        System.out.println(Fibonacci.fib(7));
    }
}
