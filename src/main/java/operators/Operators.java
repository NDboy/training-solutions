package operators;

public class Operators {

    private int n;

    public Operators() {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isEven(int n) {

        if (n % 2 == 0){
            return true;
        } else {
            return false;
        }
    }

    public int multiplyByPowerOfTwo(int i, int j) {
        return Integer.parseInt((Integer.toBinaryString(i << j)),2);
    }

//        System.out.println(Integer.parseInt((Integer.toBinaryString(16 << 1)),2));


}
