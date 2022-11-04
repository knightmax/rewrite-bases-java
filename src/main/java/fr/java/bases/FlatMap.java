package fr.java.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMap {

    public static <T,D> List<D> flatMap(List<List<T>> originalLst, Function<List<T>, Stream<? extends D>> function) {
        List<D> calculated = new ArrayList<>();
        for (List<T> list : originalLst) {
            try (Stream<? extends D> result = function.apply(list)) {
                calculated.addAll(result.toList());
            }
        }
        return calculated;
    }
}
