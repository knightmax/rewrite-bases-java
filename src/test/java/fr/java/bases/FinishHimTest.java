package fr.java.bases;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class FinishHimTest {

    @Test
    void testMultipleSteps() {

        final List<Person> persons = generateData();

        Predicate<Person> filterPersons = p -> p.age() > 30 && p.age() < 40;
        Function<Person, List<City>> mapVisitedCities = Person::visitedCities;
        Function<List<City>, Stream<? extends City>> flatMapCities = Collection::stream;
        Function<City, String> mapCountry = City::country;
        Comparator<String> comparator = Comparator.naturalOrder();

        List<String> mostVisitedCountriesByPersonsBetween30and40 = persons.stream()
              .filter(filterPersons)
              .map(mapVisitedCities)
              .flatMap(flatMapCities)
              .map(mapCountry)
              .distinct()
              .sorted(comparator)
              .toList();

        final List<String> generatedLst = FinishHim.fatality(persons,
              filterPersons,
              mapVisitedCities,
              item -> flatMapCities.apply(item).toList(),
              mapCountry,
              comparator);

        assertIterableEquals(mostVisitedCountriesByPersonsBetween30and40, generatedLst);
    }

    private List<Person> generateData() {

        final Faker faker = new Faker();
        final Random random = new Random();
        int nbMatchingAge = 0;

        List<Person> persons = new ArrayList<>();
        while(persons.size() < 100 || nbMatchingAge < 2) {

            List<City> cities = new LinkedList<>();
            for(int j = 0 ; j < random.nextInt(1, 10) ; j++) {
                final Country country = faker.country();
                cities.add(new City(country.capital(), country.name()));
            }

            final Name name = faker.name();
            int age = random.nextInt(18, 90);
            if(age > 30 && age < 40) nbMatchingAge++;
            persons.add(new Person(name.lastName(), name.firstName(), age, cities));
        }

        return persons;
    }

    record Person(String lastname, String firstname, int age, List<City> visitedCities){}
    record City(String name, String country){}
}
