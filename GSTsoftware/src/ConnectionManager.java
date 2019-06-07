

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
     
       private static String url="jdbc:h2:~/test";
       private static String driverName = "org.h2.Driver";
       private static String username ="sa";
       private static String password ="";
       private static Connection connection;
       private static String urlstring;


public static Connection getConnection() {
     try{
          Class.forName(driverName);
          try {
                connection = DriverManager.getConnection(url,username,password);
                System.out.println("Connection sucessfull");
            } catch (SQLException ex) {
                  ex.printStackTrace();
               System.out.println("Failed to create the database connection");
}
}catch (ClassNotFoundException ex){
System.out.println("Driver not found");
}
return connection;
}
}