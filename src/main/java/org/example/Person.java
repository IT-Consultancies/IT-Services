package org.example;


import java.util.ArrayList;

public abstract class  Person {
    private String name;
    private String major;
    private String password;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    private String phoneNumber;
    private String emailAddress;
    private String id;
    private ArrayList <Order> arrayList;

    public Person(String name, String password, String phoneNumber, String emailAddress, String id) {
        this.name  = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.id = id;
        this.arrayList = new ArrayList<>();
    }

    public abstract void putOrder(Order order);

    public abstract void viewOrder();

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    public ArrayList<Order> getArrayList() {
        return arrayList;
    }

    public abstract void dropOrder(int i);

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
