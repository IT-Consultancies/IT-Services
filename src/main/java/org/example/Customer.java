package org.example;


import java.util.ArrayList;

public class Customer extends Person {

    private String creditCard;
    private String location;
    private ArrayList <Order> arrayList;


    public Customer(String name, String phoneNumber ,String emailAddress,String id, String creditCard, String location) {
        super(name,phoneNumber,emailAddress,id);
        this.creditCard = creditCard;
        this.location = location;
    }

    @Override
    public void requestOrder() {

    }

    @Override
    public void viewOrder() {

    }

    @Override
    public void modifyOrder() {

    }

    @Override
    public void removeOrder() {

    }
}
