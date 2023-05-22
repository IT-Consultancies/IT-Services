package org.example;


import java.util.ArrayList;

public class Customer extends Person {

    private String creditCard;
    private String location;
    private ArrayList <Order> arrayList;


    public Customer(String name, String paswword, String phoneNumber ,String emailAddress,String id, String creditCard, String location) {
        super(name,paswword, phoneNumber,emailAddress,id);
        this.creditCard = creditCard;
        this.location = location;
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
    public String getPassword() {
        return super.getPassword();
    }
    @Override
    public ArrayList<Order> getArrayList() {
        return super.getArrayList();
    }
}
