package org.example;


import java.util.ArrayList;

public abstract class  Person {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String id;
    private ArrayList <Order> arrayList;

    public Person(String name, String phoneNumber, String emailAddress, String id) {
        this.name  = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.id = id;
        this.arrayList = new ArrayList<>();
    }

    public abstract void requestOrder();

    public abstract void viewOrder();
    public abstract void modifyOrder();
    public abstract void removeOrder();


}
