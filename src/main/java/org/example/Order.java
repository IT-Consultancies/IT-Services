package org.example;

public class Order {
    private static int orderID;
    private String customerID;
    private String employeeID;
    private Service service; // Bridge Design Pattern ********************** (Implementation in the Service class)

    public Order(String orderDate, String customerID, String employeeID, Service service) {
        orderID = orderID +1;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.service = service;
    }

    @Override
    public String toString(){
        return ("Service Name:  "+service.getServiceName() + ",  OrderID:    " + this.orderID +",  CustomerID:    " + this.customerID);
    }
}
