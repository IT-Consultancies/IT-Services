package org.example;


public class Employee extends Person {


    public Employee(String name, String phoneNumber, int id, String major) {
        super(id,name,phoneNumber);
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
