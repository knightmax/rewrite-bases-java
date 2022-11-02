package fr.java.spring.ioc.version3.webapp.service;

import fr.java.spring.ioc.common.annotation.Cacheable;
import fr.java.spring.ioc.common.annotation.Component;
import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version3.webapp.dao.PersonDAO;

import java.util.UUID;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    public PersonServiceImpl(final PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public UUID save(Person person) {
        return this.personDAO.save(person);
    }

    public Person findByIdButWithInnerMethodCall(UUID id) {
        return this.findById(id);
    }

    @Cacheable
    public Person findById(UUID id) {
        return this.personDAO.findById(id);
    }
}
