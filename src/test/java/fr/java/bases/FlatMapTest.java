package fr.java.bases;

import static fr.java.bases.FlatMap.flatMap;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

class FlatMapTest {

    private static final String[] referential =
        """
        Lorem ipsum dolor sit amet consectetur adipiscing elit Ut tempus enim ac velit imperdiet nec finibus libero efficitur
        Phasellus imperdiet sapien ac mauris sollicitudin sed tristique ex porttitor
        Phasellus et eros ullamcorper dolor dictum pulvinar
        Duis vestibulum purus eget tempus elementum ante sem sagittis lorem, et sollicitudin risus nunc quis quam
        Mauris efficitur neque ut velit ultrices ut posuere nibh vehicula In ultrices eget felis sit amet aliquam
        Mauris auctor ultrices tellus vel congue felis lacinia vitae Curabitur ullamcorper sit amet libero et dignissim
        Quisque dapibus nisl vel tristique consectetur
        """.split(" ");

    @ParameterizedTest
    @MethodSource("arguments")
    <T> void testFlatMap(final List<List<T>> listOfLists) {

        Function<List<T>, Stream<? extends T>> function = Collection::stream;
        List<T> expectedLst = listOfLists.stream()
              .flatMap(function)
              .toList();

        final List<T> generatedLst = flatMap(listOfLists, function);

        assertIterableEquals(expectedLst, generatedLst);
    }

    static <T> Stream<Arguments> arguments() {

        Random random = new Random();

        List<Integer> listInt1 = Arrays.asList(random.nextInt(20), random.nextInt(20), random.nextInt(20));
        List<Integer> listInt2 = Arrays.asList(random.nextInt(20), random.nextInt(20));
        List<Integer> listInt3 = Arrays.asList(random.nextInt(20), random.nextInt(20), random.nextInt(20));
        List<List<Integer>> listOfIntegers = Arrays.asList(listInt1, listInt2, listInt3);

        List<String> listStr1 = Arrays.asList(pickValue(random), pickValue(random), pickValue(random));
        List<String> listStr2 = Arrays.asList(pickValue(random), pickValue(random));
        List<String> listStr3 = Arrays.asList(pickValue(random), pickValue(random), pickValue(random));
        List<List<String>> listOfStrings = Arrays.asList(listStr1, listStr2, listStr3);

        return Stream.of(
              Arguments.of(listOfIntegers),
              Arguments.of(listOfStrings));
    }

    private static String pickValue(Random random) {
        return referential[random.nextInt(referential.length)];
    }
}
