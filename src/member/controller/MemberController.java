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
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertMember(MemberModel model) {
        try {
            statement.executeUpdate("INSERT INTO green.member VALUES ('"+ model.getName() + "', '" + model.getBirthday() + "', '" + model.getTel() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MemberModel> selectMember() {
        ArrayList<MemberModel> memberModels = new ArrayList<>();
        try {
            ResultSet resultset = statement.executeQuery("SELECT * FROM green.member");

            while (resultset.next()) {
                memberModels.add(new MemberModel(resultset.getString(1), resultset.getString(2), resultset.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberModels;
    }

    public void updateMember(String name, String birthday, String tel) {
        try {
            statement.executeUpdate("UPDATE green.member SET tel = '" + tel + "', birthday = '" + birthday + "' WHERE name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(String name) {
        try {
            statement.executeUpdate("DELETE FROM green.member WHERE name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MemberModel> searchMember(String content) {
        ArrayList<MemberModel> memberModels = new ArrayList<>();
        try{
            ResultSet resultset = statement.executeQuery("SELECT * FROM green.member WHERE name like '%" + content + "%';");
            while (resultset.next()) {
                memberModels.add(new MemberModel(resultset.getString(1), resultset.getString(2), resultset.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberModels;
    }
}
