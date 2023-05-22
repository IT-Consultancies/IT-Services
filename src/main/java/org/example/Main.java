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
                int userInput = input.nextInt();

                if (userInput==1){
                    personObjectTempHolder.viewOrder();
                    if(personObjectTempHolder.getArrayList().size()==0){
                        System.out.println("No Orders");
                    }
                }
                if (userInput==2){
                    System.out.println("Main Services:");
                    System.out.println("1- Network");
                    System.out.println("2- Cloud");
                    System.out.println("3- Security");
                    System.out.println("4- Database");
                    System.out.println("5- Server");
                    System.out.print("Enter Wanted Server: ");
                    userInput = input.nextInt();
                    String serviceName = "";
                    if(userInput==1){
                        serviceName = "Network";
                    }
                    if(userInput==2){
                        serviceName = "Cloud";
                    }
                    if(userInput==3){
                        serviceName = "Security";
                    }
                    if(userInput==4){
                        serviceName = "Database";
                    }
                    if(userInput==5){
                        serviceName = "Server";
                    }

                    System.out.println("Available Employees for " + serviceName + " Solution");
                    for (int i = 0; i <personArrayList.size(); i++) {
                        if(personArrayList.get(i) instanceof Employee){
                            if( ((Employee) personArrayList.get(i)).getMajor().equals(serviceName)){
                                System.out.println(personArrayList.get(i).toString());
                            }
                        }
                    }
                    System.out.print("Enter Wanted Employees: ");
                    userInput = input.nextInt();
                   // String serviceName = "";



                    System.out.println("Main Sub Services:");
                    System.out.println("1- Configuration");
                    System.out.println("2- Design");
                    System.out.println("3- Implementation");
                    System.out.println("4- Troubleshooting");
                    System.out.println("5- Consulting");
                    System.out.print("Enter Wanted Server: ");
                    userInput = input.nextInt();
                    String subserviceName = "";
                    if(userInput==1){
                        subserviceName = "Configuration";
                    }
                    if(userInput==2){
                        subserviceName = "Design";
                    }
                    if(userInput==3){
                        subserviceName = "Implementation";
                    }
                    if(userInput==4){
                        subserviceName = "Troubleshooting";
                    }
                    if(userInput==5){
                        subserviceName = "Consulting";
                    }

                }
                if (userInput==3){
                    personObjectTempHolder.viewOrder();
                    System.out.print("Choose one order above to delete: ");
                    int temp = input.nextInt();
                    personObjectTempHolder.dropOrder(temp);
                }

            }
        }




//        String services [] = {"Web design","Network config","Security"};
//
//        Scanner in = new Scanner(System.in);
//
//        String name ="";
//        int pass;
//
//        User u1 = null;
//
//        while (true){
//            System.out.println("#### Welcome to IT consultanties ####\n");
//            if(u1 == null){
//                System.out.print("Enter your username: ");
//                name = in.next();
//                System.out.print("\nEnter your password: ");
//                pass  = in.nextInt();
//                u1  = DatabaseManager.getUser(name,pass);
//            }else{
//                int cmd ;
//                System.out.println("Welcome "+name);
//                System.out.println("Choose from bellow:\n" +
//                        "Press '1' to show Our services\n" +
//                        "Press '2' to show Your orders");
//                cmd = in.nextInt();
//                if(cmd == 1 ){
//                    for (int i = 0; i <services.length; i++) {
//                        System.out.println(i+1+"-"+services[i]);
//                    }
//                    System.out.println("Choose desired services :");
//                    cmd = in.nextInt();
//
//                }else{
//                    System.out.println("This is your orders ..");
//                }
//            }
//
//        }









    }
}