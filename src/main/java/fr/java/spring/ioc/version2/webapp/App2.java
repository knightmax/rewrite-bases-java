package fr.java.spring.ioc.version2.webapp;

import fr.java.spring.ioc.common.model.DataGenerator;
import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version2.summer.context.ApplicationContext;
import fr.java.spring.ioc.version2.webapp.service.PersonService;

import java.util.UUID;

public class App2 {

    public void exec() {
        final ApplicationContext applicationContext = null; // TODO Instantiate ApplicationContext
        final PersonService personService = null; // TODO Instantiate PersonService

        Person person = DataGenerator.createPerson();
        UUID saved = personService.save(person);
        personService.findById(saved);
    }
}
