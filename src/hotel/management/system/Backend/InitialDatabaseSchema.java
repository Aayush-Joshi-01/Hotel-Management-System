package hotel.management.system.Backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InitialDatabaseSchema {
    private final static String jdbcURL = "jdbc:mysql://localhost:3309/hotel";
    private final static String user = "root";
    private final static String password = "1234567890";
    public static void schema() {
        createCustomerTableIfNotExists();
        createRoomTableIfNotExists();
        createEmployeeTableIfNotExists();
        createDriverTableIfNotExists();
        createLoginTableIfNotExists();
        createDepartmentTableIfNotExists();
    }
    private static void createTableIfNotExists(String tableName, String tableCreationQuery) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, user, password)) {
            Statement statement = connection.createStatement();
            // Check if the table exists
            if (!tableExists(statement, tableName)) {
                // If not, create the table
                statement.executeUpdate(tableCreationQuery);
                System.out.println(tableName + " table created successfully.");
            } else {
                System.out.println(tableName + " table already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static boolean tableExists(Statement statement, String tableName) throws SQLException {
        // Check if the table exists
        String checkTableExistsQuery = "SHOW TABLES LIKE '" + tableName + "'";
        return statement.executeQuery(checkTableExistsQuery).next();
    }
    private static void createCustomerTableIfNotExists() {
        String customerTableCreationQuery = "CREATE TABLE IF NOT EXISTS Customer ("
                + "id VARCHAR(30) NOT NULL,"
                + "number NUMERIC(30) PRIMARY KEY,"
                + "name VARCHAR(30) NOT NULL,"
                + "gender VARCHAR(30) NOT NULL,"
                + "country VARCHAR(30) NOT NULL,"
                + "room_number NUMERIC(30) NOT NULL,"
                + "status VARCHAR(30) NOT NULL,"
                + "deposit NUMERIC(30) NOT NULL)";
        createTableIfNotExists("Customer", customerTableCreationQuery);
    }
    private static void createRoomTableIfNotExists() {
        String roomTableCreationQuery = "CREATE TABLE IF NOT EXISTS Room ("
                + "room_number NUMERIC(30) PRIMARY KEY,"
                + "availability VARCHAR(30) NOT NULL,"
                + "clean_status VARCHAR(30) NOT NULL,"
                + "price NUMERIC(30) NOT NULL,"
                + "bed_type VARCHAR(30) NOT NULL)";
        createTableIfNotExists("Room", roomTableCreationQuery);
    }

    private static void createEmployeeTableIfNotExists() {
        String employeeTableCreationQuery = "CREATE TABLE IF NOT EXISTS Employee ("
                + "name VARCHAR(30) NOT NULL,"
                + "age NUMERIC(30) NOT NULL,"
                + "gender VARCHAR(30) NOT NULL,"
                + "job VARCHAR(30) NOT NULL,"
                + "salary NUMERIC(30) NOT NULL,"
                + "phone NUMERIC(30) NOT NULL,"
                + "adhar NUMERIC(30) PRIMARY KEY,"
                + "email VARCHAR(30) NOT NULL)";
        createTableIfNotExists("Employee", employeeTableCreationQuery);
    }
    private static void createDriverTableIfNotExists() {
        String driverTableCreationQuery = "CREATE TABLE IF NOT EXISTS Driver ("
                + "name VARCHAR(30) NOT NULL,"
                + "age NUMERIC(30) NOT NULL,"
                + "gender VARCHAR(30) NOT NULL,"
                + "company VARCHAR(30) NOT NULL,"
                + "brand VARCHAR(30) NOT NULL,"
                + "available VARCHAR(30) NOT NULL,"
                + "location VARCHAR(30) NOT NULL)";
        createTableIfNotExists("Driver", driverTableCreationQuery);
    }
    private static void createLoginTableIfNotExists() {
        String loginTableCreationQuery = "CREATE TABLE IF NOT EXISTS Login ("
                + "username VARCHAR(30) PRIMARY KEY,"
                + "password VARCHAR(30) NOT NULL)";
        createTableIfNotExists("Login", loginTableCreationQuery);
    }
    private static void createDepartmentTableIfNotExists() {
        String departmentTableCreationQuery = "CREATE TABLE IF NOT EXISTS Department ("
                + "department VARCHAR(30) PRIMARY KEY,"
                + "budget NUMERIC(30) NOT NULL)";
        createTableIfNotExists("Department", departmentTableCreationQuery);
    }
}