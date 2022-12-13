package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/onlineshopkoro", "root", "#RootMySQL1995");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


