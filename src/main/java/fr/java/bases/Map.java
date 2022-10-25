package fr.java.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {

    public static <T,D> List<D> map(List<T> originalLst, Function<T,D> function) {
        //throw new NotImplementedException("Please complete fr.java.bases.Map#map");
        
        List<D> resultLst = new ArrayList<>();
        
        for(T item:originalLst) {
            resultLst.add(function.apply(item));
        }
        
        return resultLst;
    }
}
