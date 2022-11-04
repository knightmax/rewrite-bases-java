package fr.java.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {

    public static <T,D> List<D> map(List<T> originalLst, Function<T,D> function) {
        List<D> list = new ArrayList<>();
        for (T t : originalLst) {
            D r = function.apply(t);
            list.add(r);
        }
        return list;
    }
}
