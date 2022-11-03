package fr.java.bases;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FinishHim {

    public static <P,C,S> List<S> fatality(List<P> originalLst,
          Predicate<P> filterTopLevel,
          Function<P, List<C>> mapTopLevel,
          Function<List<C>, Stream<? extends C>> flatMap,
          Function<C, S> mapSecondLevel,
          Comparator<S> comparator) {
        throw new NotImplementedException("Please complete fr.java.bases.FinishHim#fatality");
    }
}
