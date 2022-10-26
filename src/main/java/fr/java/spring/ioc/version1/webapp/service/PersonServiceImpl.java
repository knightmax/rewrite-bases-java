package fr.java.spring.ioc.version1.webapp.service;

import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version1.webapp.dao.PersonDAO;

import java.util.UUID;

public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;
    public PersonServiceImpl(final PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public UUID save(Person person) {
        return this.personDAO.save(person);
    }

    public Person findById(UUID id) {
        return this.personDAO.findById(id);
    }
}
