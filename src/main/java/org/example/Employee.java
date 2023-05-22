package org.example;


public class Employee extends Person {

    private String major;

    public Employee(String name, String password, String phoneNumber, String emailAddress, String id, String major) {
        super(name, password, phoneNumber, emailAddress, id);
        this.major = major;
    }

    @Override
    public void putOrder(Order order) {

    }

    public String getMajor() {
        return major;
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
                "major='" + major + '\'' +
                '}';
    }
}
