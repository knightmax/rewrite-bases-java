package fr.java.bases;

import static fr.java.bases.FlatMap.flatMap;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

class FlatMapTest {


    <T, D> void testFlatMap(final List<T> list, Function<T, List<D>> function) {
        List<D> expectedLst = list.stream()
              .flatMap( (T item) -> function.apply(item).stream() )
              .toList();

        final List<D> generatedLst = flatMap(list, function);

        assertIterableEquals(expectedLst, generatedLst);
    }
    
    @Test
    public void testWithWords() {
        List<String> words = Arrays.asList("abc def", "ghi", "jkl mno pqr");
        Function<String, List<String>> function = 
            (String str) -> Arrays.asList( str.split(" ") );
            
        testFlatMap(words, function);
    }
    
    @Test
    public void testWithEmptyList() {
        List<String> words = Collections.emptyList();
        Function<String, List<String>> function = 
            (String str) -> Arrays.asList( str.split(" ") );
        testFlatMap(words, function);
    }
    
    @Test
    public void testWithDifferentTypes() {
        List<String> numbers = Arrays.asList("123,456,789", "101112", "1314,1516");
        Function<String, List<Integer>> function = 
            (String str) -> {
                List<Integer> lst = new LinkedList<>();
                for(String number : str.split(","))
                    lst.add( Integer.parseInt(number) );
                return lst;
            };
        testFlatMap(numbers, function);
    }

}
