package ua.nure.kn.kuchinskiy.usermanagement.web;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BrowseServletTest extends MockServletTestCase {
    protected void setUp() throws Exception {
        super.setUp();
        createServlet(BrowseServlet.class);
    }

    public void testBrowse() {
        User user = new User("Vladimir", "Kuchinskiy", LocalDate.of(1999, 9, 23));
        List list = Collections.singletonList(user);
        getUserManager().expectAndReturn("findAll", list);
        doGet();
        Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
        assertNotNull("Could not find list of users in session", collection);
        assertSame(list, collection);
    }
}
