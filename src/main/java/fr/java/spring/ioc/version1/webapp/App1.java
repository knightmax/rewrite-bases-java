package fr.java.spring.ioc.version1.webapp;

import fr.java.spring.ioc.common.model.DataGenerator;
import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version1.webapp.dao.PersonDAO;
import fr.java.spring.ioc.version1.webapp.dao.PersonDAOImpl;
import fr.java.spring.ioc.version1.webapp.service.PersonService;
import fr.java.spring.ioc.version1.webapp.service.PersonServiceImpl;

import java.util.UUID;

public class App1 {

    public void exec() {
        final PersonDAO personDAO = new PersonDAOImpl();
        final PersonService personService = new PersonServiceImpl(personDAO);

        Person person = DataGenerator.createPerson();
        UUID saved = personService.save(person);
        personService.findById(saved);
    }
}
