package member.controller;

import member.model.MemberModel;

import java.sql.*;
import java.util.ArrayList;

public class MemberController {

    Connection connection;
    Statement statement;

    public MemberController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Green", "green", "mysql");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertMember(MemberModel model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO green.member VALUES(?,?,?)");
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getBirthday());
            preparedStatement.setString(3, model.getTel());

            preparedStatement.executeUpdate();
//            statement.executeUpdate("INSERT INTO green.member VALUES ('"+ model.getName() + "', '" + model.getBirthday() + "', '" + model.getTel() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MemberModel> selectMember() {
        ArrayList<MemberModel> memberModels = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM green.member");

            while (resultset.next()) {
                memberModels.add(new MemberModel(resultset.getString(1), resultset.getString(2), resultset.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return memberModels;
    }

    public void updateMember(String name, String birthday, String tel) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE green.member SET tel = '" + tel + "', birthday = '" + birthday + "' WHERE name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteMember(String name) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM green.member WHERE name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MemberModel> searchMember(String content) {
        ArrayList<MemberModel> memberModels = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM green.member WHERE name like '%" + content + "%';");
            while (resultset.next()) {
                memberModels.add(new MemberModel(resultset.getString(1), resultset.getString(2), resultset.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return memberModels;
    }
}
