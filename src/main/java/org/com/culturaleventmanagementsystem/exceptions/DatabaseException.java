package org.com.culturaleventmanagementsystem.exceptions;

import java.sql.SQLException;

public class DatabaseException extends SQLException {
    public DatabaseException(String msg) {
        super(msg);
    }
}
