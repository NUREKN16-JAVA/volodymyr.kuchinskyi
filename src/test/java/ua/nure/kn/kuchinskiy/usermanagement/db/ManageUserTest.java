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
        ManageUser manageUser = new ManageUser();
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        Integer userId = manageUser.create(user);
        assertNotNull(userId);
        manageUser.destroy(userId);
    }

    public void testFindAll() {
        ManageUser manageUser = new ManageUser();
        Integer firstUserId = manageUser.create(new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH));
        Integer secondUserId = manageUser.create(new User(NEW_FIRST_NAME, NEW_LAST_NAME, NEW_DATE_OF_BIRTH));
        List users = null;
        try {
            users = manageUser.findAll();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        assertEquals(new Long(users.size()), manageUser.countAll());
        manageUser.destroy(firstUserId);
        manageUser.destroy(secondUserId);
    }

    public void testFind() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        ManageUser manageUser = new ManageUser();
        user.setId(manageUser.create(user));
        User testedUser = manageUser.find(user.getId());
        assertEquals(user.getId(), testedUser.getId());
        manageUser.destroy(user.getId());
    }

    public void testUpdate() {
        User user = new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
        ManageUser manageUser = new ManageUser();
        user.setId(manageUser.create(user));
        User updatedUser = new User(NEW_FIRST_NAME, NEW_LAST_NAME, NEW_DATE_OF_BIRTH);
        manageUser.update(user.getId(), updatedUser);
        updatedUser = manageUser.find(user.getId());
        assertNotSame(user.getFullName(), updatedUser.getFullName());
        assertNotSame(user.getAge(), updatedUser.getAge());
        manageUser.destroy(user.getId());
    }

    public void testDestroy() {
        ManageUser manageUser = new ManageUser();
        Integer userId = manageUser.create(new User(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH));
        Long countBefore = manageUser.countAll();
        manageUser.destroy(userId);
        Long countAfter = manageUser.countAll();
        assertTrue(countBefore.intValue() != countAfter.intValue());
    }
}