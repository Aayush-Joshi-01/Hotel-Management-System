package hotel.management.system;
import hotel.management.system.Backend.InitialDatabaseSchema;
import hotel.management.system.Frontend.StartingPage;
import java.sql.Connection;
import java.sql.DriverManager;
public class HotelManagementSystem {
    public final static String jdbcURL = "jdbc:mysql://localhost:3309/hotel";
    public final static String user = "root";
    public final static String password = "1234567890";
    public static void main(String[] args) {
//        Connection conn = null;
//		try{
//			//Register the JDBC driver
//			Class.forName(DB_DRIVER);
// 
//			//Open the connection
//			conn = DriverManager.
//			getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
// 
//			if(conn != null){
//			   System.out.println("Successfully connected.");
//			}else{
//			   System.out.println("Failed to connect.");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
        StartingPage startingPageFrame = new StartingPage();
//        InitialDatabaseSchema db = new InitialDatabaseSchema();
//        db.schema();
        startingPageFrame.startingPage();

    }
}