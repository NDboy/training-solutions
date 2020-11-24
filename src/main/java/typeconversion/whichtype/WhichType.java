package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType (String str) {
        long longNumber = Long.parseLong(str);
        List<Type> types = new ArrayList<>();
        for (Type type : Type.values()) {
            if ((type.getMin() <= longNumber) && (longNumber <= type.getMax())) {
                types.add(type);
            }
        }
        return types;
    }
}
