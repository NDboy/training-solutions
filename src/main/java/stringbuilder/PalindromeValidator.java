package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder sbWord = new StringBuilder(word.trim().toLowerCase());

        return sbWord.toString().equals(sbWord.reverse().toString());
    }
}
