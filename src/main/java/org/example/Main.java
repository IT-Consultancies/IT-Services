package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String [] subServices = {"Configuration","Design","Implementation","Troubleshooting","Consulting"};
        Scanner input = new Scanner(System.in);
        System.out.println("Hello on IT Consultancies Services Software");


        Person personObjectTempHolder = null;

       while (true){
            System.out.print("Username: ");
            String name = input.next();
            System.out.print("Password: ");
            int password = input.nextInt();

            if (DatabaseManager.getCustomer(name,password) != null){
               personObjectTempHolder = DatabaseManager.getCustomer(name,password);
               System.out.println("Correct Credentials");
               break;
            }else if(DatabaseManager.getEmployee(name,password) != null){
                personObjectTempHolder = DatabaseManager.getEmployee(name,password);
                System.out.println("Correct Credentials");
                break;
            }else{
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
                System.out.println("4- Subscribe to our newsletter");
                System.out.println("5- Unubscribe to our newsletter");
                System.out.println("6- Exit");

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
                    System.out.println("\nMain Services:");
                    DatabaseManager.getAllServices();
                    System.out.print("\nEnter Wanted Service: ");

                    userInput = input.nextInt();
                    ServiceFactory serviceFactory = new ServiceFactory();
                    Service currService = serviceFactory.getService(userInput);
                    String serviceName = currService.getServiceName();

                    System.out.println("\nAvailable Employees for " + serviceName + " Solution");

                    ArrayList <Employee> emp = DatabaseManager.getEmployeeForAServoice(serviceName);

                    for (int i = 0; i < emp.size(); i++) {
                        System.out.println(emp.get(i));
                    }

                    Person chosenEmp =null;

                    while(chosenEmp == null){
                        System.out.print("\nEnter Wanted Employee by thier ID: ");
                        userInput = input.nextInt();
                        for (int i = 0; i < emp.size(); i++) {
                            if(emp.get(i).getId() == userInput){
                                chosenEmp = emp.get(i);
                                break;
                            }else{
                                System.out.println("\nplease enter the correct ID");
                            }
                        }
                    }

                    System.out.println("\nSub Services:");
                    for (int i = 0; i < subServices.length; i++) {
                        System.out.println(i+1+"- "+subServices[i]);
                    }
                    System.out.print("\nEnter Wanted Sub Service: ");
                    userInput = input.nextInt();

                    String subserviceName = subServices[userInput-1];
                    currService.setSubServiceName(subserviceName);
                    currService.getService();
                    DatabaseManager.setOrderToCustomer(
                            personObjectTempHolder.getId(),currService.getId(),chosenEmp.getId()
                            ,currService.getPrice(),currService.getSubServiceName()
                    );
                }
                if (BigUserInput==3){
                    if(personObjectTempHolder.getArrayList().size()==0){
                        System.out.println("No Orders");
                    }else{
                        personObjectTempHolder.viewOrder();
                        System.out.print("Choose one order above to delete by orderID: ");
                        int temp = input.nextInt();
                        personObjectTempHolder.dropOrder(temp);
                    }
                }

                if (BigUserInput==4){
                    ITconsultant itcompany = new ITconsultant();
                    itcompany.getNotifcationService().subscribe(new EmailMsgListener(((Customer) personObjectTempHolder).getEmailAddress()));
                    System.out.println("You are now Subscribed !");
                }

                if (BigUserInput==5){
                    ITconsultant itcompany = new ITconsultant();
                    itcompany.getNotifcationService().unsubscribe(new EmailMsgListener(((Customer) personObjectTempHolder).getEmailAddress()));
                    System.out.println("You are now Unsubscribed !");
                }

                if (BigUserInput==6){
                    exitTheMenu = true;
                }
            }
        }else{
            boolean exitTheMenu = false;
            while (!exitTheMenu) {
                System.out.println();
                System.out.println("Employee Main Menu");
                System.out.println("1- Show All Orders");
                System.out.println("2- Exit");

                System.out.print("Choose: ");

                int BigUserInput = input.nextInt();
                int userInput;

                if (BigUserInput == 1) {
                    personObjectTempHolder.viewOrder();
                    if (personObjectTempHolder.getArrayList().size() == 0) {
                        System.out.println("No Orders");
                    }
                }else{
                    exitTheMenu =true;
                }
            }
        }










    }
}