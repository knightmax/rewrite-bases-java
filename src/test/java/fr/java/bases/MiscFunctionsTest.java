package fr.java.bases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
                .toList();
        
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
    
    static Stream<Arguments> originalListOnly() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(1, 1, 2, 3, 5, 5, 10, 12)),
                Arguments.of(List.of("toto", "tata", "tutu")));
    }
    
}
