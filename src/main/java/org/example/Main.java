package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Database stuff (fill data)
        Person c1 = new Customer("Mohammed", "123", "054761222", "18@kau.edu.sa", "876", "2222" ,"Jeddah, Nakheel street");
        Person c2 = new Customer("Ahmed", "321", "0542222", "19@kau.edu.sa", "432", "333" ,"Makkah, Buhyrat street");
        ArrayList <Person> personArrayList = new ArrayList<Person>();
        personArrayList.add(c1);
        personArrayList.add(c2);

        //Database stuff (fill data)
        Person e1 = new Employee("Malik", "333", "0555321", "mm@hotmail.com", "321", "Network" );
        Person e2 = new Employee("Suhaib", "121", "02225321", "mxr@mail.com", "12345678", "Network" );
        personArrayList.add(e1);
        personArrayList.add(e2);

        String [] ProvidedServices = {"Network","Cloud","Security","Database","Server"};
        String [] subServices = {"Configuration","Design","Implementation","Troubleshooting","Consulting"};

        Scanner input = new Scanner(System.in);
        System.out.println("Hello on IT Consultancies Services Software");

        Person personObjectTempHolder = null;
        boolean loginStatus =false;
        boolean exit = false;
        while (!exit){

        System.out.print("Username:  ");
        String name = input.next();
        System.out.print("Password:  ");
        String password = input.next();

        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getName().equals(name) && personArrayList.get(i).getPassword().equals(password)){
                personObjectTempHolder = personArrayList.get(i);
                System.out.println("Correct Credentials");
                loginStatus = true;
                exit = true;
                break;
            }
          }
        if (loginStatus==false){
            System.out.println("Wrong Credentials!");
            System.out.println("Please enter correct credentials");
            }
        }

        //Menu of customer
        if (personObjectTempHolder instanceof Customer){
            boolean exitTheMenu = false;
            while (!exitTheMenu){
                System.out.println();
                System.out.println("Customer Main Menu");
                System.out.println("1- Show All Orders");
                System.out.println("2- Request Order");
                System.out.println("3- Delete Order");
                System.out.print("Choose: ");

                int BigUserInput = input.nextInt();
                int userInput ;

                if (BigUserInput==1){
                    personObjectTempHolder.viewOrder();
                    if(personObjectTempHolder.getArrayList().size()==0){
                        System.out.println("No Orders");
                    }
                }
                if (BigUserInput==2){
                    System.out.println("Main Services:");

                    for (int i = 0; i < ProvidedServices.length; i++) {
                        System.out.println(i+1+"- "+ProvidedServices[i]);
                    }
                    System.out.print("Enter Wanted Server: ");

                    userInput = input.nextInt();
                    ServiceFactory serviceFactory = new ServiceFactory();
                    Service currService = serviceFactory.getService(userInput);
                    String serviceName = currService.getServiceName();

                    System.out.println("Available Employees for " + serviceName + " Solution");

                    ArrayList <Person> emp = new ArrayList<>();

                    for (int i = 0; i <personArrayList.size(); i++) {
                        if(personArrayList.get(i) instanceof Employee){
                            if( personArrayList.get(i).getMajor().equals(serviceName) ){
                                emp.add(personArrayList.get(i));
                            }
                        }
                    }
                    for (int i = 0; i < emp.size(); i++) {
                        System.out.println(i+1+"- "+emp.get(i));
                    }
                    System.out.print("Enter Wanted Employees : ");
                    userInput = input.nextInt();
                    Person chosenEmp =  emp.get(userInput-1);

                    System.out.println("Main Sub Services:");
                    for (int i = 0; i < subServices.length; i++) {
                        System.out.println(i+1+"- "+subServices[i]);
                    }
                    System.out.print("Enter Wanted Sub Service: ");
                    userInput = input.nextInt();
                    String subserviceName = subServices[userInput-1];
                    currService.setSubServiceName(subserviceName);

                    Order order = new Order(personObjectTempHolder.getName(),chosenEmp.getName(),currService);
                    personObjectTempHolder.putOrder(order);
                    System.out.println(order);


                }
                if (BigUserInput==3){
                    personObjectTempHolder.viewOrder();
                    System.out.print("Choose one order above to delete: ");
                    int temp = input.nextInt();
                    personObjectTempHolder.dropOrder(temp);
                }
            }
        }










    }
}