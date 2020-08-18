
//import java.sql.Connection;
import java.util.*;

public class Main {
  public static void main(String args[]) {
    // // Do something...

    // // Create the ConnectionPool:
    // JDBCConnectionPool pool = new JDBCConnectionPool(
    // "org.hsqldb.jdbcDriver", "jdbc:hsqldb://localhost/mydb",
    // "sa", "secret");

    // // Get a connection:
    // Connection con = pool.checkOut();

    // // Use the connection

    // // Return the connection:
    // pool.checkIn(con);

    Scanner keyboard = new Scanner(System.in);
    UserData userData = UserData.getInstance();
    Room Library = new Room();

    System.out.print("Enter name:");
    userData.setName(keyboard.nextLine());

    System.out.print("Enter birth year:");
    userData.setDob(Integer.parseInt(keyboard.nextLine()));

    int year = 2020 - userData.getDob();
    System.out.println("Your Age is: " + year);

  }
}
