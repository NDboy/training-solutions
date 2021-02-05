package thirdparty;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class WordCounter {

    public int numberOfWords(String str) {
        return Splitter.on(CharMatcher.anyOf(" ,."))
                .trimResults()
                .omitEmptyStrings()
                .splitToList(str)
                .size();
    }
}
