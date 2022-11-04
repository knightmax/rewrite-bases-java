package fr.java.bases;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MiscFunctions {

    public static <T> Long count(List<T> originalLst) {
        return (long) originalLst.size();
    }

    public static <T> List<T> distinct(List<T> originalLst) {
        Set<T> uniqueValues = new LinkedHashSet<>(originalLst);
        return List.copyOf(uniqueValues);
    }

    public static <T> Optional<T> findAny(List<T> originalLst) {
        Optional<T> calculatedLst = Optional.empty();
        for (T t : originalLst) {
            calculatedLst = Optional.of(t);
            break;
        }

        return calculatedLst;
    }

    public static <T> Optional<T> findFirst(List<T> originalLst) {
        Optional<T> calculatedLst = Optional.empty();
        for (T t : originalLst) {
            calculatedLst = Optional.of(t);
            break;
        }
        return calculatedLst;
    }

}
