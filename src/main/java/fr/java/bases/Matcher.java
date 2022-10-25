package fr.java.bases;

import java.util.List;
import java.util.function.Predicate;

public class Matcher {
    public static <T> Boolean anyMatch(List<T> originalLst, Predicate<T> predicate) {
        throw new NotImplementedException("Please complete fr.java.bases.Matcher#anyMatch");
    }

    public static <T> Boolean allMatch(List<T> originalLst, Predicate<T> predicate) {
        throw new NotImplementedException("Please complete fr.java.bases.Matcher#allMatch");
    }

    public static <T> Boolean noneMatch(List<T> originalLst, Predicate<T> predicate) {
        throw new NotImplementedException("Please complete fr.java.bases.Matcher#noneMatch");
    }
}
