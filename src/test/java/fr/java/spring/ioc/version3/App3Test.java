package fr.java.spring.ioc.version3;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import fr.java.spring.ioc.common.model.Person;
import fr.java.spring.ioc.version3.summer.handler.ProxyInvocationHandler;
import fr.java.spring.ioc.version3.webapp.App3;
import fr.java.spring.ioc.version3.webapp.dao.PersonDAO;
import fr.java.spring.ioc.version3.webapp.service.PersonService;
import fr.java.spring.ioc.version3.webapp.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

class App3Test {

    private static final UUID ID = UUID.randomUUID();

    private static PersonDAO mockPersonDAO() {
        PersonDAO personDAO = mock(PersonDAO.class);
        when(personDAO.findById(any(UUID.class))).thenReturn(new Person("titi", "toto", new Date()));
        return personDAO;
    }

    private static ProxyInvocationHandler initProxy(PersonDAO personDAO) {
        PersonService personService = new PersonServiceImpl(personDAO);
        return new ProxyInvocationHandler(personService);
    }

    @Test
    void testEverythingIsFine() {
        App3 app = new App3();
        assertDoesNotThrow(app::exec);
    }

    @Test
    void testCache() throws NoSuchMethodException {
        PersonDAO personDAO = mockPersonDAO();
        ProxyInvocationHandler proxy = initProxy(personDAO);

        proxy.invoke(null, PersonService.class.getMethod("findById", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findById", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findById", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findById", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findById", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findById", UUID.class), List.of(ID).toArray());

        verify(personDAO, times(1)).findById(any(UUID.class));
    }

    @Test
    void testInnerMethodCacheIgnored() throws NoSuchMethodException {
        PersonDAO personDAO = mockPersonDAO();
        ProxyInvocationHandler proxy = initProxy(personDAO);

        proxy.invoke(null, PersonService.class.getMethod("findByIdButWithInnerMethodCall", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findByIdButWithInnerMethodCall", UUID.class), List.of(ID).toArray());
        proxy.invoke(null, PersonService.class.getMethod("findByIdButWithInnerMethodCall", UUID.class), List.of(ID).toArray());

        verify(personDAO, times(3)).findById(any(UUID.class));
    }
}
