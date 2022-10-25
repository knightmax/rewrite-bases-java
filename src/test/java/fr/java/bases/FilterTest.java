package fr.java.bases;

import static fr.java.bases.Filter.filter;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

class FilterTest {

    private <T> void assertStreamEquals(List<T> originalLst, Predicate<T> predicate) {

        final List<T> expectedLst = originalLst.stream()
              .filter(predicate)
              .toList();

        final List<T> generatedLst = filter(originalLst, predicate);

        assertIterableEquals(expectedLst, generatedLst);
    }

    @Test
    void testFilterWords() {

        final List<String> originalStream = Arrays.asList("spray", "limit", "elite", "exuberant", "destruction", "present");
        final Predicate<String> minLength = s -> s.length() > 6;

        assertStreamEquals(originalStream, minLength);
    }

    @Test
    void testFilterNumbers() {

        final List<Integer> originalLst = Arrays.asList(12, 5, 8, 130, 44);
        final Predicate<Integer> minValue = i -> (i > 10);

        assertStreamEquals(originalLst, minValue);
    }
}
