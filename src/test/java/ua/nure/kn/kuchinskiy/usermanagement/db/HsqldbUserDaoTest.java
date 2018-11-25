package ua.nure.kn.kuchinskiy.usermanagement.db;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.time.LocalDate;

public class HsqldbUserDaoTest extends DatabaseTestCase {
    private HsqldbUserDao dao;
    private ConnectionFactory connectionFactory;


    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl();
        return new DatabaseConnection(connectionFactory.createConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataset = new XlsDataSet(getClass().getClassLoader().getResourceAsStream("usersDataset.xml"));
        return dataset;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao(connectionFactory);
    }

    public void testCreate() {
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