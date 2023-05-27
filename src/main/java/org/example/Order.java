package org.example;

public class Order {
    private int id;
    private String customerID;

    public int getId() {
        return id;
    }

    private String employeeID;
    private Service service; // Bridge Design Pattern ********************** (Implementation in the Service class)

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
