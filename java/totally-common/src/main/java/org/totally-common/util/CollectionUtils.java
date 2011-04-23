package org.totallycommon.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T> List<T> toList(Iterable<T> iterable) {
        if (iterable instanceof List)
            return (List<T>)iterable;

        if (iterable instanceof Collection)
            return new ArrayList<T>((Collection<T>)iterable);

        List<T> result = new ArrayList<T>();
        for (T item : iterable)
            result.add(item);

        return result;
    }
}
