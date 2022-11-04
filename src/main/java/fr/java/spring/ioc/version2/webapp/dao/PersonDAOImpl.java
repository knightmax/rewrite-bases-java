package fr.java.spring.ioc.version2.webapp.dao;

import fr.java.spring.ioc.common.annotation.Component;
import fr.java.spring.ioc.common.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Component
public class PersonDAOImpl implements PersonDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAOImpl.class);

    private final Map<UUID, Person> persons = new HashMap<>();

    @Override
    public UUID save(Person person) {

        LOGGER.info("Save person {}", person);

        UUID id = UUID.randomUUID();
        persons.put(id, person);

        LOGGER.info("Saved with id {}", id);

        return id;
    }

    @Override
    public Person findById(UUID id) {
        LOGGER.info("Find person {}", id);

        return Optional.ofNullable(persons.get(id))
              .orElseThrow(NoSuchElementException::new);
    }
}
