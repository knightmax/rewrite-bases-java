package fr.java.bases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MiscFunctions {
    private static Random RAND = new Random();
    
    public static <T> Long count(List<T> originalLst) {
        // throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#count");
        Long count = 0L;
        for (T item : originalLst) {
            count++;
        }
        return count;
    }
    
    public static <T> List<T> distinct(List<T> originalLst) {
        // throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#distinct");
        List<T> deduplicatedLst = new ArrayList<>();
        for (T item : originalLst) {
            if (!deduplicatedLst.contains(item)) {
                deduplicatedLst.add(item);
            }
        }
        return deduplicatedLst;
    }
    
    public static <T> Optional<T> findAny(List<T> originalLst) {
        // throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#findAny");
        if (originalLst.isEmpty()) {
            return Optional.empty();
        }
        
        return Optional.ofNullable(originalLst.get(RAND.nextInt(originalLst.size())));
    }
    
    public static <T> Optional<T> findFirst(List<T> originalLst) {
        // throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#findFirst");
        if (originalLst.isEmpty()) {
            return Optional.empty();
        }
        
        return Optional.ofNullable(originalLst.get(0));
    }
    
}
