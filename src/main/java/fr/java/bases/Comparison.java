package fr.java.bases;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Comparison {

    public static <T> Optional<T> min(List<T> originalLst, Comparator<? super T> comparator) {
        boolean init = false;
        T min = null;
        for (T t : originalLst) {
            if(!init || comparator.compare(t, min) < 0) {
                init = true;
                min = t;
            }
        }
        return Optional.ofNullable(min);
    }

    public static <T> Optional<T> max(List<T> originalLst, Comparator<? super T> comparator) {
        boolean init = false;
        T max = null;
        for (T t : originalLst) {
            if(!init || comparator.compare(t, max) > 0) {
                init = true;
                max = t;
            }
        }
        return Optional.ofNullable(max);
    }
}
