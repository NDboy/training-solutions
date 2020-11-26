package typeconversion.dataloss;

public class DataLoss {

    public void dataLoss() {
        long original = 0;
        long newNum = 0;
        long counter = 0;
        while (newNum == original) {
            original++;
            newNum = (long) (float) original;
        }
        while (counter < 3) {
            System.out.println("Original: " + original + " in binary: " + Long.toBinaryString(original));
            System.out.println("Converted: " + newNum + " in binary: " + Long.toBinaryString(newNum));
            counter++;
        }

    }

    public static void main(String[] args) {
        new DataLoss().dataLoss();

    }

}
