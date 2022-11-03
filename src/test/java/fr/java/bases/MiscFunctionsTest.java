package fr.java.bases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MiscFunctionsTest {
    
    @ParameterizedTest
    @MethodSource("originalListOnly")
    <T> void testCount(List<T> originalList) {
        Long expected = originalList.stream().count();
        Long actual = MiscFunctions.count(originalList);
        
        assertEquals(expected, actual);
    }
    
    @ParameterizedTest
    @MethodSource("originalListOnly")
    <T> void testDistinct(List<T> originalList) {
        List<T> expected = originalList.stream()
                .distinct()
                .collect(Collectors.toList());
        
        List<T> actual = MiscFunctions.distinct(originalList);
        
        assertIterableEquals(expected, actual);
    }
    
    @ParameterizedTest
    @MethodSource("originalListOnly")
    <T> void testFindAny(List<T> originalList) {
        Optional<T> expected = originalList.stream().findAny();
        Optional<T> actual = MiscFunctions.findAny(originalList);
        
        // Since findAny is non-deterministic, there is no actual way to ensure that the standard library's and this dojo's implementations will
        // return the same element. We can only check that if the standard implementation can find an element, then ours should too.
        assertEquals(expected.isEmpty(), actual.isEmpty());
    }
    
    @ParameterizedTest
    @MethodSource("originalListOnly")
    <T> void testFindFirst(List<T> originalList) {
        Optional<T> expected = originalList.stream().findFirst();
        Optional<T> actual = MiscFunctions.findFirst(originalList);
        
        if (expected.isEmpty()) {
            assertTrue(actual.isEmpty());
        } else {
            assertTrue(actual.isPresent());
            assertEquals(expected.get(), actual.get());
        }
    }
    
    @ParameterizedTest
    @MethodSource("listAndComparator")
    <T> void testMin(List<T> originalList, Comparator<? super T> comparator) {
        Optional<T> expected = originalList.stream().min(comparator);
        Optional<T> actual = MiscFunctions.min(originalList, comparator);
        
        if (expected.isEmpty()) {
            assertTrue(actual.isEmpty());
        } else {
            assertTrue(actual.isPresent());
            assertEquals(expected.get(), actual.get());
        }
    }
    
    @ParameterizedTest
    @MethodSource("listAndComparator")
    <T> void testMax(List<T> originalList, Comparator<? super T> comparator) {
        Optional<T> expected = originalList.stream().max(comparator);
        Optional<T> actual = MiscFunctions.max(originalList, comparator);
        
        if (expected.isEmpty()) {
            assertTrue(actual.isEmpty());
        } else {
            assertTrue(actual.isPresent());
            assertEquals(expected.get(), actual.get());
        }
    }
    
    @ParameterizedTest
    @MethodSource("listAndAccumulator")
    <T> void testReduce(List<T> originalList, BinaryOperator<T> accumulator) {
        Optional<T> expected = originalList.stream().reduce(accumulator);
        Optional<T> actual = MiscFunctions.reduce(originalList, accumulator);
        
        if (expected.isEmpty()) {
            assertTrue(actual.isEmpty());
        } else {
            assertTrue(actual.isPresent());
            assertEquals(expected.get(), actual.get());
        }
    }
    
    static Stream<Arguments> originalListOnly() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(1, 1, 2, 3, 5, 5, 10, 12)),
                Arguments.of(List.of("toto", "tata", "tutu")));
    }
    
    static Stream<Arguments> listAndComparator() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), Comparator.naturalOrder()),
                Arguments.of(Collections.emptyList(), Comparator.reverseOrder()),
                Arguments.of(List.of(1, 1, 2, 3, 5, 5, 10, 12), Comparator.naturalOrder()),
                Arguments.of(List.of(1, 1, 2, 3, 5, 5, 10, 12), Comparator.reverseOrder()),
                Arguments.of(List.of("toto", "tata", "tutu"), Comparator.naturalOrder()),
                Arguments.of(List.of("toto", "tata", "tutu"), Comparator.reverseOrder()));
    }
    
    static Stream<Arguments> listAndAccumulator() {
        return Stream.of(
                // Operation on no elements
                Arguments.of(Collections.emptyList(), sum()),
                Arguments.of(Collections.emptyList(), product()),
                Arguments.of(Collections.emptyList(), concat()),
                
                // Operation on many elements
                Arguments.of(List.of(1, 2, 3, 4, 5), sum()),
                Arguments.of(List.of(1, 2, 3, 4, 5), product()),
                Arguments.of(List.of("toto", "tata", "tutu"), concat()),
                
                // Operation on exactly 1 (one) element
                Arguments.of(List.of(1), sum()),
                Arguments.of(List.of(1), product()),
                Arguments.of(List.of("toto"), concat()));
    }
    
    private static BinaryOperator<Integer> sum() {
        return Integer::sum;
    }
    
    private static BinaryOperator<Integer> product() {
        return (Integer a, Integer b) -> a * b;
    }
    
    private static BinaryOperator<String> concat() {
        return (String a, String b) -> a + b;
    }
}
