package fr.java.bases;

import java.util.List;
import java.util.function.Predicate;

public class Matcher {
    public static <T> Boolean anyMatch(List<T> originalLst, Predicate<T> predicate) {
        for (T t : originalLst) {
            if(predicate.test(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> Boolean allMatch(List<T> originalLst, Predicate<T> predicate) {
        for (T t : originalLst) {
            if(!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }

    public static <T> Boolean noneMatch(List<T> originalLst, Predicate<T> predicate) {
        for (T t : originalLst) {
            if(predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
