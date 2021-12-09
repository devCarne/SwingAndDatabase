package member.controller;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberController {

    Connection connection;
    Resultset resultset;
    Statement statement;

    public MemberController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Green", "green", "mysql");
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
