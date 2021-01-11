package week11.week11d01;

public class DivisorFinder {
    public int findDivisors(int num){
        String strNum = Integer.toString(num);
        int counter = 0;
        try {
            for (int i = 0; i < strNum.length(); i++) {
                if (i < strNum.length() - 1 && num % Integer.parseInt(strNum.substring(i, i + 1)) == 0) {
                    counter++;
                } else if (i == strNum.length() - 1 && num % Integer.parseInt(strNum.substring(i)) == 0) {
                    counter++;
                }
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Not a number", nfe);
        }
        return counter;
    }
}
