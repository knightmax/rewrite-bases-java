package fr.java.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static <T> List<T> filter(List<T> originalLst, Predicate<T> predicate) {
        List<T> list = new ArrayList<>();
        for(T val : originalLst) {
            if(predicate.test(val)) {
                list.add(val);
            }
        }

        return list;
    }
}
