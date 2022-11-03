package fr.java.bases;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Reduce {
    
    public static <T> Optional<T> reduce(List<T> originalLst, BinaryOperator<T> accumulator) {
        // throw new NotImplementedException("Please complete fr.java.bases.Reduce#reduce");
        if (originalLst.isEmpty()) {
            return Optional.empty();
        }
        
        T reduction = originalLst.get(0);
        
        if (1 == originalLst.size()) {
            return Optional.ofNullable(reduction);
        }
        
        for (int i = 1; i < originalLst.size(); i++) {
            reduction = accumulator.apply(reduction, originalLst.get(i));
        }
        
        return Optional.ofNullable(reduction);
    }
    
}
