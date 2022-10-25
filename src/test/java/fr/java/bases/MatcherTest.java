package fr.java.bases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatcherTest {

    @ParameterizedTest
    @MethodSource("arguments")
    <T> void testAnyMatch(List<T> originalList, Predicate<T> predicate) {
        final Boolean expected = originalList.stream()
                .anyMatch(predicate);

        final Boolean actual = Matcher.anyMatch(originalList, predicate);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    <T> void testAllMatch(List<T> originalList, Predicate<T> predicate) {
        final Boolean expected = originalList.stream()
                .allMatch(predicate);

        final Boolean actual = Matcher.allMatch(originalList, predicate);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    <T> void testNoneMatch(List<T> originalList, Predicate<T> predicate) {
        final Boolean expected = originalList.stream()
                .noneMatch(predicate);

        final Boolean actual = Matcher.noneMatch(originalList, predicate);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        List<String> fruits = Arrays.asList("banane", "pomme", "fraise", "framboise", "abricot");
        Predicate<String> minLength = fruit -> fruit.length() > 4;
        Predicate<String> maxLength = fruit -> fruit.length() < 7;
        Predicate<String> startsWithF = fruit -> fruit.startsWith("f");
        Predicate<String> startsWithO = fruit -> fruit.startsWith("o");

        return Stream.of(
                Arguments.of(fruits, minLength),
                Arguments.of(fruits, maxLength),
                Arguments.of(fruits, startsWithF),
                Arguments.of(fruits, startsWithO));
    }
}
