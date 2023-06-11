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

    public static void setOrderToCustomer(int userID, String serviceName, int empID, int price, String subService){
        Connection conn;
        int srID = getSpecficServicesByName(serviceName);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "INSERT INTO orders (userID,serviceID,employeeID,subService,price) VALUES (?,?,?,?,?) ";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, userID);
            statement.setInt(2, srID);
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

    public static ArrayList <Order> getCustomerOrders(int userID,int empid){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query ;
            PreparedStatement statement;
            ResultSet resultSet;
            if(userID == -1){
                 query = "SELECT * FROM Orders where employeeID = ?";
                 statement = conn.prepareStatement(query);
                 statement.setInt(1, empid);

            }else{
                query = "SELECT * FROM Orders where userID = ?";
                statement = conn.prepareStatement(query);
                statement.setInt(1, userID);
            }

            resultSet = statement.executeQuery();


            ArrayList <Order> ord = new ArrayList<>();
            while (resultSet.next()) {
                int serviceID = resultSet.getInt("serviceID");
                int empeID = resultSet.getInt("employeeID");
                int orderID = resultSet.getInt("orderID");
                int uid = resultSet.getInt("userID");
                String subSerivce = resultSet.getString("subService");

                String serv = getSpecficServices(serviceID);
                ServiceFactory sf = new ServiceFactory();
                Service currServ =  sf.getService(serv);
                currServ.setSubServiceName(subSerivce);
                currServ.getService();
                ord.add(new Order(orderID,getSpecificCustomer(uid),getSpecificEmp(empeID),currServ));
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

    public static Employee getEmployee(String name , int pass){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query = "SELECT * FROM employee WHERE name = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, pass);


            ResultSet resultSet = statement.executeQuery();

            int uid = -1;
            String ename = null;
            String ephone = null;
            int emajorid = -1;

            while (resultSet.next()) {
                ename = resultSet.getString("name");
                ephone = resultSet.getString("ephone");
                emajorid = resultSet.getInt("major_id");
                uid = resultSet.getInt("employeeID");
            }

            if(uid == -1){
                return null;
            }
            statement.close();
            resultSet.close();
            return new Employee(ename,ephone,uid,getSpecficServices(emajorid));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSpecficServices(int serviceID){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();
            String query = "SELECT * FROM service where serviceID = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, serviceID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString("serviceName");
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

    public static int getSpecficServicesByName(String serviceName){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();
            String query = "SELECT * FROM service where serviceName = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, serviceName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("serviceID");
            }
            statement.close();
            resultSet.close();
            return -1;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList <EmailMsgListener> getSubsrcibers(){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();
            String query = "SELECT * FROM customers where isSubscribed = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();

            ArrayList <EmailMsgListener> emails = new ArrayList<>();
            while (resultSet.next()) {
                 emails.add(new EmailMsgListener(resultSet.getString("cus_email")));
            }
            statement.close();
            resultSet.close();

            return emails;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateSubsriber(int sub, String email){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DatabaseConnection.getCon();

            String query ;
            PreparedStatement statement;
            query = "UPDATE customers set isSubscribed = ? where cus_email = ?";
            if(sub == -1){
                statement = conn.prepareStatement(query);
                statement.setInt(1, 0);
                statement.setString(2, email);

            }else{
                statement = conn.prepareStatement(query);
                statement.setInt(1, 1);
                statement.setString(2, email);
            }
            statement.executeUpdate();

            statement.close();



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
