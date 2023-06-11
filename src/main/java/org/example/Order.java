package org.example;

public class Order {
    private int id;
    private String customerID;

    public int getId() {
        return id;
    }

    private String employeeID;
    private Service service; // Bridge Design Pattern ********************** (Implementation in the Service class)

    /* Where Order can be an abstract class for future purposes
    * and cash class extends Order so it can be like Order with Cash
    * and ApplePay class extends Order so it can be like Order with ApplePay
    * */

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + id + '\'' +
                "customerID='" + customerID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", service=" + service +
                '}';
    }

    public Order(int id,String customerID, String employeeID, Service service) {
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.service = service;
        this.id = id;
    }

}
