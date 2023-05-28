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
        super.setArrayList(DatabaseManager.getCustomerOrders(-1,super.getId()));
        for (int i = 0; i < super.getArrayList().size() ; i++) {
            System.out.println(super.getArrayList().get(i).toString());
        }
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
