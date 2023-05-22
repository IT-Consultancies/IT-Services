package org.example;


public class Employee extends Person {


    public Employee(String name, String password, String phoneNumber, String emailAddress, String id, String major) {
        super(name, password, phoneNumber, emailAddress, id);
        super.setMajor(major);
    }

    @Override
    public void putOrder(Order order) {

    }

    @Override
    public void viewOrder() {

    }


    @Override
    public void dropOrder(int i) {

    }

    @Override
    public String toString() {
        return super.toString()+"   Employee{" +
                "major='" + super.getMajor() + '\'' +
                '}';
    }
}
