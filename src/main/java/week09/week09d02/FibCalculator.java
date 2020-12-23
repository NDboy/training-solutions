package week09.week09d02;

public class FibCalculator {

    public static long sumEvens(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        long sum = 0;
        long fib = 1;
        long puffer = 0;
        long puffer2 = 1;
        for (int i = 0; fib * 2 + puffer2 <= bound; i++) {
            puffer = fib;
            fib = puffer + puffer2;
            puffer2 = puffer;
            if (fib % 2 == 0) {
                sum += fib;
            }
        }
        return sum;
    }

}


//    A week09d02 csomagban készíts egy osztályt FibCalculator néven.
//    Ennek legyen egy metódusa long sumEvens(int bound) néven.
//    Ennek a metódusnak a feladata az, hogy összeadja a páros fibonacci számokat addig,
//    amig a következő fibonacci szám nem nagyobb, mint bound, majd visszadja a végredményt.