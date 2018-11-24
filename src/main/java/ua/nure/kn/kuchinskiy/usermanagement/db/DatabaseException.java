package ua.nure.kn.kuchinskiy.usermanagement.db;

import java.sql.SQLException;

public class DatabaseException extends Exception {
    public DatabaseException() {}

    public DatabaseException(SQLException e) {}

    public DatabaseException(String number_of_the_inserted_rows) {
    }
}
