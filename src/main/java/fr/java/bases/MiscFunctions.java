package fr.java.bases;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;

public class MiscFunctions {
    
    private static final Random RAND = new Random();
    
    public static <T> Long count(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#count");
    }
    
    public static <T> List<T> distinct(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#distinct");
    }
    
    public static <T> Optional<T> findAny(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#findAny");
    }
    
    public static <T> Optional<T> findFirst(List<T> originalLst) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#findFirst");
    }
    
    public static <T> Optional<T> min(List<T> originalLst, Comparator<? super T> comparator) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#min");
    }
    
    public static <T> Optional<T> max(List<T> originalLst, Comparator<? super T> comparator) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#max");
    }
    
    public static <T> Optional<T> reduce(List<T> originalLst, BinaryOperator<T> accumulator) {
        throw new NotImplementedException("Please complete fr.java.bases.MiscFunctions#reduce");
    }
}
