package ua.nure.kn.kuchinskiy.usermanagement.db;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.sql.*;
import java.util.Collection;

public class HsqldbUserDao implements UserDao {

    private static final String INSERT_QUERY = "INSERT INTO users (firstName, lastName, dateOfBirth) VALUES (?, ?, ?)";
    private ConnectionFactory connectionFactory;

    public HsqldbUserDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public User create(User user) throws DatabaseException {
        Connection connection = connectionFactory.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, new Date(user.getDateOfBirth().toEpochDay()));
            int n  = statement.executeUpdate();
            if (n != 1) {
                throw new DatabaseException("Number of the inserted rows: " + n);
            }
            CallableStatement callableStatement = connection.prepareCall("call IDENTITY()");
            ResultSet keys = callableStatement.executeQuery();
            if (keys.next()) {
                user.setId(new Long(keys.getLong(1)));
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    @Override
    public User update(User user) throws DatabaseException {
        return null;
    }

    @Override
    public User delete(User user) throws DatabaseException {
        return null;
    }

    @Override
    public User find(Long id) throws DatabaseException {
        return null;
    }

    @Override
    public Collection findAll() throws DatabaseException {
        return null;
    }
}
