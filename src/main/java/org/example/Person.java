package src.main.java.org.example;

import java.util.ArrayList;

public abstract class  Person {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String id;
    private ArrayList <Order> arrayList;

    public abstract void requestOrder();

    public abstract void viewOrder();
    public abstract void modifyOrder();
    public abstract void removeOrder();


}
