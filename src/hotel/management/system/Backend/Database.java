package hotel.management.system.Backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    private final static String jdbcURL = "jdbc:mysql://localhost:3309/hotel";
    private final static String user = "root";
    private final static String password = "1234567890";
    public static void executeQuery(String tableName, String query) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, user, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Query executed successfully for table: " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error executing query for table: " + tableName);
        }
    }
}