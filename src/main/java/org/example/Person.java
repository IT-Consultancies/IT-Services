package org.example;


import java.util.ArrayList;

public abstract class  Person {
    private String name;
    private String major;
    private String phoneNumber;
    private int id;
    private ArrayList <Order> arrayList;

    public Person(int id ,String name, String phoneNumber ) {
        this.name  = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.arrayList = new ArrayList<>();
    }

    public abstract void putOrder(Order order);

    public abstract void viewOrder();

    public String getName() {
        return name;
    }

    public void setArrayList(ArrayList<Order> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ArrayList<Order> getArrayList() {
        return arrayList;
    }

    public abstract void dropOrder(int i);


}
