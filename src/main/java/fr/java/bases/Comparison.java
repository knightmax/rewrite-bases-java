package fr.java.bases;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Comparison {
    
    public static <T> Optional<T> min(List<T> originalLst, Comparator<? super T> comparator) {
        // throw new NotImplementedException("Please complete fr.java.bases.Comparison#min");
        if (originalLst.isEmpty()) {
            return Optional.empty();
        }
        
        T minimum = originalLst.get(0);
        for (T item : originalLst) {
            if (comparator.compare(minimum, item) > 0) {
                minimum = item;
            }
        }
        return Optional.ofNullable(minimum);
    }
    
    public static <T> Optional<T> max(List<T> originalLst, Comparator<? super T> comparator) {
        // throw new NotImplementedException("Please complete fr.java.bases.Comparison#max");
        if (originalLst.isEmpty()) {
            return Optional.empty();
        }
        
        T minimum = originalLst.get(0);
        for (T item : originalLst) {
            if (comparator.compare(minimum, item) < 0) {
                minimum = item;
            }
        }
        return Optional.ofNullable(minimum);
    }
}
