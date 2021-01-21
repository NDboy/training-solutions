package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null) {
            throw new IllegalArgumentException("binaryString null");
        }
        boolean[] result = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result[i] = true;
            } else if (str.charAt(i) == '0') {
                result[i] = false;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        for (boolean item: arr) {
            if (item) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
}
