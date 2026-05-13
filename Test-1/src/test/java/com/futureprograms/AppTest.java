package com.futureprograms;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for Servlet App.
 */
public class AppTest {
    
    /**
     * Test que la clase App es un Servlet
     */
    @Test
    public void testAppIsServlet() {
        App app = new App();
        assertNotNull("App debe ser instanciable", app);
        assertTrue("App debe extender HttpServlet", 
            app instanceof jakarta.servlet.http.HttpServlet);
    }

    /**
     * Rigourous Test :-)
     */
    
    /**
     * Test básico de funcionalidad
     */
    @Test
    public void testAppBasic() {
        assertTrue("Test básico", true);
    }
}
