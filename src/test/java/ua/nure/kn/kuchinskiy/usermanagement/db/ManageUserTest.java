package ua.nure.kn.kuchinskiy.usermanagement.db;

import junit.framework.TestCase;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;

public class ManageUserTest extends TestCase {

    public String FIRST_NAME = "Vladimir";
    public String LAST_NAME = "Kuchinskiy";
    public LocalDate DATE_OF_BIRTH = LocalDate.of(1999, 9, 23);

    public void testCreate() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        assertNotNull(ManageUser.create(user));
    }
}