package org.example;

public class Order {
    private static int orderID;
    private String customerID;
    private String employeeID;
    private Service service; // Bridge Design Pattern ********************** (Implementation in the Service class)

    @Override
    public String toString() {
        return "Order{" +
                "customerID='" + customerID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", service=" + service +
                '}';
    }

    public Order(String customerID, String employeeID, Service service) {
        orderID = orderID +1;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.service = service;
    }

}
