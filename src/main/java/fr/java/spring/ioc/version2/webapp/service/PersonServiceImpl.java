package fr.java.spring.ioc.version2.webapp.service;

import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version2.webapp.dao.PersonDAO;
import fr.java.spring.ioc.version2.webapp.dao.PersonDAOImpl;

import java.util.UUID;

// TODO annotate ?
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    public PersonServiceImpl(final PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public PersonServiceImpl() {
        this.personDAO = new PersonDAOImpl();
    }

    public UUID save(Person person) {
        return this.personDAO.save(person);
    }

    public Person findById(UUID id) {
        return this.personDAO.findById(id);
    }
}
