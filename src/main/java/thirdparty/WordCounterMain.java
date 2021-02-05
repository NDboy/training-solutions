package thirdparty;

public class WordCounterMain {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("0000000000000000000000000000000000");
        }
        else {
            System.out.println(new WordCounter().numberOfWords(args[0]));
        }
    }
}
