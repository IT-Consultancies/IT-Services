package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        String services [] = {"Web design","Network config","Security"};

        Scanner in = new Scanner(System.in);

        String name ="";
        int pass;

        User u1 = null;

        while (true){
            System.out.println("#### Welcome to IT consultanties ####\n");
            if(u1 == null){
                System.out.print("Enter your username: ");
                name = in.next();
                System.out.print("\nEnter your password: ");
                pass  = in.nextInt();
                u1  = DatabaseManager.getUser(name,pass);
            }else{
                int cmd ;
                System.out.println("Welcome "+name);
                System.out.println("Choose from bellow:\n" +
                        "Press '1' to show Our services\n" +
                        "Press '2' to show Your orders");
                cmd = in.nextInt();
                if(cmd == 1 ){
                    for (int i = 0; i <services.length; i++) {
                        System.out.println(i+1+"-"+services[i]);
                    }
                    System.out.println("Choose desired services :");
                    cmd = in.nextInt();

                }else{
                    System.out.println("This is your orders ..");
                }
            }

        }









    }
}