package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public Dictionary() {
        this.dictionaryItems = dictionaryItems;
    }

    public void addItem(String item, List<String> itemTranslation) {
        for (DictionaryItem it: dictionaryItems) {
            if (!dictionaryItems.contains(it)) {
                it.addTranslations(itemTranslation);
            }
        }
    }

    public List<String> findTranslations(String item) {
        for (DictionaryItem it : dictionaryItems) {
            if (!dictionaryItems.contains(it)) {
                return it.getTranslations();
            }
        }
        return new ArrayList<>();
    }



    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("alma", Arrays.asList("apple"));
        dictionary.addItem("körte", Arrays.asList("pear"));
        dictionary.addItem("barack", Arrays.asList("peach"));
        dictionary.addItem("ananász", Arrays.asList("pineapple"));
        dictionary.addItem("dinnye", Arrays.asList("melon"));

        System.out.println(dictionary.findTranslations("alma"));


    }


}

