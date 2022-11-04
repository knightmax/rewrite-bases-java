package fr.java.spring.ioc.version2.webapp.dao;

import fr.java.spring.ioc.common.model.Person;

import java.util.UUID;

public interface PersonDAO {

    UUID save(Person person);

    Person findById(UUID id);
}
