package exceptionmulticatch.converter;

public class AnswerStat {
    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String str) {
        boolean [] result;
        try {
            result = binaryStringConverter.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException("binaryString not valid", ex);
        }
        return result;
    }

    public int answerTruePercent(String answers) {
        boolean [] result = convert(answers);
        int counter = 0;
        for (boolean item: result) {
            if (item) {
                counter++;
            }
        }
        return (int)Math.round((double) counter / answers.length() * 100.0);
    }

}
