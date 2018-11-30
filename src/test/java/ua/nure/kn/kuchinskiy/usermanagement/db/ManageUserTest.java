package ua.nure.kn.kuchinskiy.usermanagement.db;

import junit.framework.TestCase;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;
import java.util.List;

public class ManageUserTest extends TestCase {

    private String FIRST_NAME = "Vladimir";
    private String LAST_NAME = "Kuchinskiy";
    private LocalDate DATE_OF_BIRTH = LocalDate.of(1999, 9, 23);

    private String NEW_FIRST_NAME = "FIRST_NAME";
    private String NEW_LAST_NAME = "LAST_NAME";
    private LocalDate NEW_DATE_OF_BIRTH = LocalDate.of(1998, 1, 30);

    public void testCreate() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        assertNotNull(ManageUser.create(user));
    }

    public void testFindAll() {
        List users = ManageUser.findAll();
        assertEquals(new Long(users.size()), ManageUser.countAll());
    }

    public void testFind() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        user.setId(ManageUser.create(user));
        User testedUser = ManageUser.find(user.getId());
        assertEquals(user.getId(), testedUser.getId());
    }

    public void testUpdate() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        user.setId(ManageUser.create(user));
        User updatedUser = new User(NEW_FIRST_NAME, NEW_LAST_NAME, NEW_DATE_OF_BIRTH);
        ManageUser.update(user.getId(), updatedUser);
        updatedUser = ManageUser.find(user.getId());
        assertNotSame(user.getFullName(), updatedUser.getFullName());
        assertNotSame(user.getAge(), updatedUser.getAge());
    }
}