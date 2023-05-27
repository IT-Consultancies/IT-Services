package org.example;

import java.sql.*;
public class DatabaseManager {


//    public static User getUser(String name , int pass) {
//        Connection conn;
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DatabaseConnection.getCon();
//
//            String query = "SELECT * FROM users WHERE name = ? AND pass = ?";
//            PreparedStatement statement = conn.prepareStatement(query);
//
//            statement.setString(1, name);
//            statement.setInt(2, pass);
//
//
//            ResultSet resultSet = statement.executeQuery();
//
//            String uname = null;
//            String uphone = null;
//            int uid = -1;
//
//            while (resultSet.next()) {
//                 uname = resultSet.getString("name");
//                 uphone = resultSet.getString("phone");
//                 uid = resultSet.getInt("id");
//            }
//
//            if(uname == null || uphone == null  || uid == -1){
//                System.out.println("User not found !");
//                return null;
//            }
//            statement.close();
//            resultSet.close();
//            conn.close();
//
//            return new User(uid,uname);
//
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
