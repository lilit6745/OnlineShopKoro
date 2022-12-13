package DAO;

import DB.ConnectDB;
import DB.Product;
import DB.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    private Statement statement = null;
    private ResultSet resultSet = null;

    private String toQuotedString(String s) {
        return '"' + s + '"';
    }

    public void insertUserRow(User user) {
        try {
            statement = ConnectDB.connect().createStatement();
            String row = "insert into users values (NULL," + toQuotedString(user.getUserFirstName()) + ','
                    + toQuotedString(user.getUserLastName()) + ','
                    +  toQuotedString(user.getImplUserBirthDate())  + ','
                    + toQuotedString(user.getUserEmail()) + ','
                    + toQuotedString(user.getUserPassword()) + ")";

            System.out.println(row);
            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
