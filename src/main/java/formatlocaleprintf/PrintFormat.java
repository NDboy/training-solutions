package formatlocaleprintf;

import java.util.IllegalFormatException;
import java.util.Locale;


public class PrintFormat {

    public String formatMessageWithIntegerParameters(String formatString, Integer i, Integer j) {
        String str = "";
        try {
            str = String.format("%d  %d  %d", i, j);
        }
        catch (IllegalFormatException ife) {
            throw new IllegalArgumentException("Less objects then expected in format String!");
        }
        return str;
    }

    public String printFormattedText(Double number) {
        return String.format(new Locale("hu", "HU"),"Total is: %,.2f Ft", number);
    }

    public String printFormattedText(int count, String fruit) {
        return String.format(new Locale("hu", "HU"), "We counted %d %s in the basket", count, fruit);
    }

    public String printFormattedText(int number) {
        return String.format(new Locale("hu", "HU"), "Right edge of numbers set at 4 spaces from text:%4d", number);
    }

    public String printFormattedText(Integer i, Integer j, Integer k) {
        return String.format(new Locale("hu", "HU"), "Multiple objects containing text:" + i + "\t" + j + "\t" + k);
    }


}
