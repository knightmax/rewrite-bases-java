package fr.java.spring.ioc.version2.webapp.service;

import fr.java.spring.ioc.common.model.Person;

import java.util.UUID;

// No annotation necessary on interface type
public interface PersonService {

    UUID save(Person person);

    Person findById(UUID id);
}
