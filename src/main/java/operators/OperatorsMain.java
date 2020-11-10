package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();
        System.out.println(operators.isEven(51));
        System.out.println(operators.isEven(50));


//        System.out.println(Integer.parseInt((Integer.toBinaryString(16)),2));
//        System.out.println(Integer.parseInt((Integer.toBinaryString(16 >> 1)),2));
//        System.out.println(Integer.parseInt((Integer.toBinaryString(16 << 1)),2));
//        System.out.println(Integer.parseInt((Integer.toBinaryString(16 << 2)),2));
//        System.out.println(Integer.parseInt((Integer.toBinaryString(16 << 3)),2));
        System.out.println(Integer.parseInt((Integer.toBinaryString(16 << 4)),2));
//        System.out.println(Integer.parseInt((Integer.toBinaryString(13 >> 1)),2));
//        System.out.println(Integer.parseInt((Integer.toBinaryString(13 << 2)),2));

        System.out.println(operators.multiplyByPowerOfTwo(16,4));





    }
}
