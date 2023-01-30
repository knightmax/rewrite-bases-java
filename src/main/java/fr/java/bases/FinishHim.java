package fr.java.bases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class FinishHim {

    public static <P,C,S> List<S> fatality(List<P> originalLst,
          Predicate<P> filterTopLevel,
          Function<P, List<C>> mapTopLevel,
          Function<List<C>, List<? extends C>> flatMap,
          Function<C, S> mapSecondLevel,
          Comparator<S> comparator) {

        // filter
        List<P> filterLst = new ArrayList<>();
        for(P val : originalLst) {
            if(filterTopLevel.test(val)) {
                filterLst.add(val);
            }
        }

        // map + flatmap
        List<C> mapLst = new ArrayList<>();
        for (P p : filterLst) {
            List<C> r = mapTopLevel.apply(p);
            mapLst.addAll(r);
        }

        // map + distinct + comparing
        SortedSet<S> result = new TreeSet<>(comparator);
        for(C val : mapLst) {
            S s = mapSecondLevel.apply(val);
            result.add(s);
        }

        return List.copyOf(result);
    }
}
