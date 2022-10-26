package fr.java.spring.ioc.version1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import fr.java.spring.ioc.version1.webapp.App1;
import org.junit.jupiter.api.Test;

class App1Test {

    @Test
    void testEverythingIsFine() {
        App1 app = new App1();
        assertDoesNotThrow(app::exec);
    }
}
