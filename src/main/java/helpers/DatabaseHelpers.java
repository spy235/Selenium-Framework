
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Utility class for managing database connections.
 * 
 * <p>
 * This class provides methods to establish connections to a MySQL database.
 * </p>
 */
public class DatabaseHelpers {
	/**
     * Constructs a new DatabaseHelpers instance.
     */
    public DatabaseHelpers() {
        super();
    }
    /**
     * Establishes a connection to a MySQL database.
     * 
     * @param hostName The hostname of the database server.
     * @param dbName   The name of the database.
     * @param userName The username for the database.
     * @param password The password for the database.
     * @return A Connection object representing the database connection.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException {

        // Ví dụ: jdbc:mysql://localhost:3306/saleserp
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);

        return conn;
    }

}
