package fr.java.spring.ioc.version2.webapp.service;

import fr.java.spring.ioc.common.model.Person;

import java.util.UUID;

// TODO annotate ?
public interface PersonService {

    UUID save(Person person);

    Person findById(UUID id);
}
