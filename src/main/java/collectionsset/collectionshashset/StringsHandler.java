package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        return new HashSet<>(stringCollection);
    }


    public Set<String> selectIdenticalStrings(Set<String> strings, Set<String> anotherStrings) {
        Set<String> common = new HashSet<>();
        for (String string: strings) {
            if (anotherStrings.contains(string)) {
                common.add(string);
            }
        }
        return common;
    }
}
