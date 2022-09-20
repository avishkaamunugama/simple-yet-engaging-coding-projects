package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    public Connection connection;

    public Connection getConnection(){

        String dbName = "ComputerFirm";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establishes a connection to a database by obtaining a Connection object
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" +dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();  // tells you what the error is and where in the code this happened.
        }


        return  connection;
    }

}
