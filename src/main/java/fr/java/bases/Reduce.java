package fr.java.bases;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Reduce {

    public static <T> Optional<T> reduce(List<T> originalLst, BinaryOperator<T> accumulator) {
        boolean init = false;
        T value = null;
        for (T t : originalLst) {
            if(!init) {
                init = true;
                value = t;
            } else {
                value = accumulator.apply(value, t);
            }
        }
        return Optional.ofNullable(value);
    }

}
