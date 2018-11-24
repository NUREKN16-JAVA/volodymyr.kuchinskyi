package ua.nure.kn.kuchinskiy.usermanagement.db;

import ua.nure.kn.kuchinskiy.usermanagement.User;

import java.util.Collection;

public interface UserDao {
    User create(User user) throws DatabaseException;

    User update(User user) throws DatabaseException;

    User delete(User user) throws DatabaseException;

    User find(Long id) throws DatabaseException;

    Collection findAll() throws DatabaseException;
}
