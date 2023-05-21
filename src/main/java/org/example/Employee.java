package org.example;


public class Employee extends Person {

    private String major;
    private String salary;

    public Employee(String name, String phoneNumber, String emailAddress, String id) {
        super(name, phoneNumber, emailAddress, id);
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
