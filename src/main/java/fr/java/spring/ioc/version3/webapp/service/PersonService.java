package fr.java.spring.ioc.version3.webapp.service;

import fr.java.spring.ioc.common.model.Person;

import java.util.UUID;

public interface PersonService {

    UUID save(Person person);

    Person findByIdButWithInnerMethodCall(UUID id);

    Person findById(UUID id);
}
