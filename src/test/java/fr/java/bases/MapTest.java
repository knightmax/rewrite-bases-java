package fr.java.bases;

import static fr.java.bases.Map.map;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class MapTest {

    @Test
    void testMap() {

        final List<Integer> originalLst = Arrays.asList(1, 2, 3);
        final Function<Integer, Integer> squared = i -> (i * i);

        final List<Integer> expectedLst = originalLst.stream()
              .map(squared)
              .toList();

        final List<Integer> generatedLst = map(originalLst, squared);

        assertEquals(expectedLst, generatedLst);
    }
}
