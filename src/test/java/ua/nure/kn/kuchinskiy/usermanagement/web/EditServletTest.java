package ua.nure.kn.kuchinskiy.usermanagement.web;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;

public class EditServletTest extends MockServletTestCase {
    protected void setUp() throws Exception {
        super.setUp();
        createServlet(EditServlet.class);
    }

    public void testEdit() {
        LocalDate date = LocalDate.of(1999, 9, 23);
        User user = new User("Vladimir", "Kuchinskiy", date);
        Integer userId = getUserManager().create(user);

        addRequestParameter("id", userId.toString());
        addRequestParameter("firstName", "Vladimir");
        addRequestParameter("lastName", "Kuchinskiy");
        addRequestParameter("dateOfBirth", date.toString());
        addRequestParameter("okButton", "Ok");
        doPost();
    }
}
