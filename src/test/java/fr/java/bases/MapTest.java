package fr.java.bases;

import static fr.java.bases.Map.map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class MapTest {

    private <T,D> void assertStreamEquals(List<T> originalLst, Function<T,D> function) {

        final List<D> expectedLst = originalLst.stream()
              .map(function)
              .toList();

        final List<D> generatedLst = map(originalLst, function);

        assertIterableEquals(expectedLst, generatedLst);
    }

    @Test
    void testMapSameType() {

        final List<Integer> originalLst = Arrays.asList(1, 2, 3);
        final Function<Integer, Integer> squared = i -> (i * i);

        assertStreamEquals(originalLst, squared);
    }

    @Test
    void testMapDifferentType() {

        final List<Integer> originalLst = Arrays.asList(1, 2, 3);
        final Function<Integer, String> numbered = i -> String.format("Item number %d", i);

        assertStreamEquals(originalLst, numbered);
    }
}
