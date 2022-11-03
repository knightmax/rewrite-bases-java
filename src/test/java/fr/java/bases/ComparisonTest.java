package fr.java.bases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComparisonTest {
    
    @ParameterizedTest
    @MethodSource("listAndComparator")
    <T> void testMin(List<T> originalList, Comparator<? super T> comparator) {
        Optional<T> expected = originalList.stream().min(comparator);
        Optional<T> actual = Comparison.min(originalList, comparator);
        
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
        Optional<T> actual = Comparison.max(originalList, comparator);
        
        if (expected.isEmpty()) {
            assertTrue(actual.isEmpty());
        } else {
            assertTrue(actual.isPresent());
            assertEquals(expected.get(), actual.get());
        }
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
    
}
