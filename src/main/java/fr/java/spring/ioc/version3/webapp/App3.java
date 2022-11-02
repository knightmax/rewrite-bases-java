package fr.java.spring.ioc.version3.webapp;

import fr.java.spring.ioc.common.model.DataGenerator;
import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version3.summer.context.ApplicationContext;
import fr.java.spring.ioc.version3.webapp.service.PersonService;

import java.util.UUID;

public class App3 {

    public void exec() {
        final ApplicationContext applicationContext = new ApplicationContext(App3.class);
        final PersonService personService = applicationContext.getBean(PersonService.class);

        Person person = DataGenerator.createPerson();
        UUID saved = personService.save(person);
        personService.findById(saved);
    }
}
