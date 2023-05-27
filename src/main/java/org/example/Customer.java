package org.example;


import java.util.ArrayList;

public class Customer extends Person {

    private int subscribed;
    private String emailAddress;


    public Customer(String name, String phoneNumber ,String emailAddress,String id , int subscribed) {
        super(id,name, phoneNumber);
        this.emailAddress = emailAddress;
        this.subscribed = subscribed;
    }

    @Override
    public void putOrder(Order order) {
        super.getArrayList().add(order);
    }

    @Override
    public void viewOrder() {
        for (int i = 0; i < super.getArrayList().size() ; i++) {
            System.out.println(super.getArrayList().get(i).toString());
        }
    }

    @Override
    public void dropOrder(int i) {
        super.getArrayList().remove(i);
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
