package fr.java.spring.ioc.version1.webapp;

import fr.java.spring.ioc.common.model.DataGenerator;
import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version1.webapp.dao.PersonDAO;
import fr.java.spring.ioc.version1.webapp.service.PersonService;

import java.util.UUID;

public class App1 {

    public void exec() {
        final PersonDAO personDAO = null; // TODO Instantiate PersoDAO
        final PersonService personService = null; // TODO Instantiate PersonService

        Person person = DataGenerator.createPerson();
        UUID saved = personService.save(person);
        personService.findById(saved);
    }
}
