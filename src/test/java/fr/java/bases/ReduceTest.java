package fr.java.bases;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReduceTest {
    
    private static final BinaryOperator<Integer> SUM = Integer::sum;
    private static final BinaryOperator<Integer> PRODUCT = (Integer a, Integer b) -> a * b;
    private static final BinaryOperator<String> CONCAT = (String a, String b) -> a + b;
    
    @ParameterizedTest
    @MethodSource("listAndAccumulator")
    <T> void testReduce(List<T> originalList, BinaryOperator<T> accumulator) {
        Optional<T> expected = originalList.stream().reduce(accumulator);
        Optional<T> actual = Reduce.reduce(originalList, accumulator);
        
        if (expected.isEmpty()) {
            assertTrue(actual.isEmpty());
        } else {
            assertTrue(actual.isPresent());
            assertEquals(expected.get(), actual.get());
        }
    }
    
    static Stream<Arguments> listAndAccumulator() {
        return Stream.of(
                // Operation on no elements
                Arguments.of(Collections.emptyList(), SUM),
                Arguments.of(Collections.emptyList(), PRODUCT),
                Arguments.of(Collections.emptyList(), CONCAT),
                
                // Operation on many elements
                Arguments.of(List.of(1, 2, 3, 4, 5), SUM),
                Arguments.of(List.of(1, 2, 3, 4, 5), PRODUCT),
                Arguments.of(List.of("toto", "tata", "tutu"), CONCAT),
                
                // Operation on exactly 1 (one) element
                Arguments.of(List.of(1), SUM),
                Arguments.of(List.of(1), PRODUCT),
                Arguments.of(List.of("toto"), CONCAT));
    }
    

}
