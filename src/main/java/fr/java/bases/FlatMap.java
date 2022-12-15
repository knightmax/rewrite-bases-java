package fr.java.bases;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class FlatMap {

    public static <T,D> List<D> flatMap(List<T> originalLst, Function<T, List<D>> function) {
        List<D> calculated = new LinkedList<>();
        for (T element : originalLst) {
            calculated.addAll(function.apply(element));
        }
        return calculated;
    }
}
