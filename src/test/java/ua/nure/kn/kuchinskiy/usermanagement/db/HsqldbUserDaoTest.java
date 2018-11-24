package ua.nure.kn.kuchinskiy.usermanagement.db;

import junit.framework.TestCase;
import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;

public class HsqldbUserDaoTest extends TestCase {
    private HsqldbUserDao dao;
    private ConnectionFactory connectionFactory;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        connectionFactory = new ConnectionFactoryImpl();
        dao = new HsqldbUserDao(connectionFactory);
    }

    public void create() {
        User user = new User();
        user.setFirstName("Vladimir");
        user.setLastName("Kuchinskiy");
        user.setDateOfBirth(LocalDate.of(1999,9,23));
        assertNull(user.getId());
        try {
            user = dao.create(user);
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
        assertNotNull(user.getId());
    }
}