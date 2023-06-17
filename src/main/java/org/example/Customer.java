package org.example;


import java.util.ArrayList;

public class Customer extends Person {

    private int subscribed;
    private String emailAddress;


    public Customer(String name, String phoneNumber ,String emailAddress,int id , int subscribed) {
        super(id,name, phoneNumber);
        this.emailAddress = emailAddress;
        this.subscribed = subscribed;
        super.setArrayList(DatabaseManager.getCustomerOrders(super.getId(),-1));

    }

    public int getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(int subscribed) {
        this.subscribed = subscribed;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void putOrder(Order order) {
        super.getArrayList().add(order);
    }

    @Override
    public String toString() {
        return super.toString()+"Customer{" +
                "subscribed=" + subscribed +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public void viewOrder() {
       // super.setArrayList(DatabaseManager.getCustomerOrders(super.getId(),-1));
        for (int i = 0; i < super.getArrayList().size() ; i++) {
            System.out.println(super.getArrayList().get(i).toString());
        }
    }

    @Override
    public void dropOrder(int orderID) {
        boolean isThereOrderWithThatID = false;
        for (int i = 0; i < super.getArrayList().size() ; i++) {
            if(super.getArrayList().get(i).getId() == orderID){
                isThereOrderWithThatID = true;
                super.getArrayList().remove(i);
                break;
            }
        }
        if(isThereOrderWithThatID){
           DatabaseManager.removeOrder(orderID);
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public ArrayList<Order> getArrayList() {
        return super.getArrayList();
    }
}
