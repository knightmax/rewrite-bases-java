package fr.java.spring.ioc.version2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import fr.java.spring.ioc.version2.webapp.App2;
import org.junit.jupiter.api.Test;

class App2Test {

    @Test
    void testEverythingIsFine() {
        App2 app = new App2();
        assertDoesNotThrow(app::exec);
    }
}
