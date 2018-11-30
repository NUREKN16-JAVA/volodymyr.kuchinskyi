package ua.nure.kn.kuchinskiy.usermanagement.db;

import junit.framework.TestCase;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;
import java.util.List;

public class ManageUserTest extends TestCase {

    private String FIRST_NAME = "Vladimir";
    private String LAST_NAME = "Kuchinskiy";
    private LocalDate DATE_OF_BIRTH = LocalDate.of(1999, 9, 23);

    public void testCreate() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        assertNotNull(ManageUser.create(user));
    }

    public void testFindAll() {
        List users = ManageUser.findAll();
        assertEquals(new Long(users.size()), ManageUser.countAll());
    }
}