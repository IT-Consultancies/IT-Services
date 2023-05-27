package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {


    public static Customer getCustomer(String name , int pass) {
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "SELECT * FROM customers WHERE cus_name = ? AND cus_pass = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, pass);


            ResultSet resultSet = statement.executeQuery();

            int uid = -1;
            String cname = null;
            String cphone = null;
            String cemail = null;
            int iSubscribed = -1;

            while (resultSet.next()) {
                cname = resultSet.getString("cus_name");
                cemail = resultSet.getString("cus_email");
                cphone = resultSet.getString("cus_phone");
                uid = resultSet.getInt("cus_id");
                iSubscribed = resultSet.getInt("isSubscribed");
            }

            if(uid == -1){
                System.out.println("User not found !");
                return null;
            }
            statement.close();
            resultSet.close();
            return new Customer(cname,cphone,cemail,uid,iSubscribed);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getAllServices(){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();
            String query = "SELECT * FROM service ";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int counter = 1;
            while (resultSet.next()) {
                System.out.println(counter+"- "+resultSet.getString("serviceName"));
                counter++;
            }
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList <Employee> getEmployeeForAServoice(String servicename){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "SELECT * FROM service INNER JOIN employee ON employee.major_id = service.serviceID WHERE serviceName = ? ";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, servicename);
            ResultSet resultSet = statement.executeQuery();

            ArrayList <Employee> emp = new ArrayList<>();
            while (resultSet.next()) {
                emp.add(new Employee(resultSet.getString("name"),resultSet.getString("ephone")
                ,resultSet.getInt("employeeID"),resultSet.getString("serviceName")));
            }
            statement.close();
            resultSet.close();

            return emp;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setOrderToCustomer(int userID, int serviceID, int empID, int price, String subService){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "INSERT INTO orders (userID,serviceID,employeeID,subService,price) VALUES (?,?,?,?,?) ";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, userID);
            statement.setInt(2, serviceID);
            statement.setInt(3, empID);
            statement.setString(4, subService);
            statement.setInt(5, price);
            statement.executeUpdate();

            statement.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList <Order> getCustomerOrders(int userID){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "SELECT * FROM Orders where userID = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            ArrayList <Order> ord = new ArrayList<>();
            while (resultSet.next()) {
                int serviceID = resultSet.getInt("serviceID");
                int empeID = resultSet.getInt("employeeID");
                int orderID = resultSet.getInt("orderID");
                String subSerivce = resultSet.getString("subService");

                ServiceFactory sf = new ServiceFactory();
                Service currServ =  sf.getService(serviceID+1);
                currServ.setSubServiceName(subSerivce);
                currServ.getService();
                ord.add(new Order(orderID,getSpecificCustomer(userID),getSpecificEmp(empeID),currServ));
            }
            statement.close();
            resultSet.close();

            return ord;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private static String getSpecificCustomer(int userID){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "SELECT cus_name FROM customers where cus_id = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            String name;
            while (resultSet.next()) {
                name = resultSet.getString("cus_name");
                return name;
            }
            statement.close();
            resultSet.close();

            return null;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getSpecificEmp(int userID){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "SELECT name FROM employee where employeeID = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                return name;
            }
            statement.close();
            resultSet.close();

            return null;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeOrder(int orderID){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "DELETE from orders where orderID = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, orderID);
            statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
