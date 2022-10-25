package fr.java.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static <T> List<T> filter(List<T> originalLst, Predicate<T> predicate) {
        //throw new NotImplementedException("Please complete fr.java.bases.Filter#filter");
        List<T> resultLst = new ArrayList<>();
        
        for(T item:originalLst) {
            if(predicate.test(item)) {
                resultLst.add(item);
            }
        }
        
        return resultLst;
    }
}
