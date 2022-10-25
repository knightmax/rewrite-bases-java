package fr.java.bases;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMap {

    public static <T,D> List<D> flatMap(List<List<T>> originalLst, Function<List<T>, Stream<? extends D>> function) {
        throw new NotImplementedException("Please complete fr.java.bases.FlatMap#flatMap");
    }
}
