package fr.java.spring.ioc.common.model;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class DataGenerator {

    private DataGenerator() {
        // Utility class
    }

    public static Person createPerson() {
        final Faker faker = new Faker();
        final Name name = faker.name();
        return new Person(name.lastName(), name.firstName(), faker.date().birthday());
    }
}
