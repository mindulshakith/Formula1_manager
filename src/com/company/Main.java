package com.company;

import java.util.Scanner;

public class Main extends Formula1ChampionshipManager    {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        String u_input ;

        while (cont) {

                    //Enter the give number
                    System.out.println("------------------------- Formla1_2021_Menu -------------------------");
                    System.out.println("Please Enter Your Choice");
                    System.out.println("Enter 1 - To Create a new Driver ");
                    System.out.println("Enter 2 - To Delete a Driver     ");
                    System.out.println("Enter 3 - To Change the Driver of an Existing Team ");
                    System.out.println("Enter 4 - To Display Statistics of the Driver ");
                    System.out.println("Enter 5 - To Display the Formula 1 Driver Table ");
                    System.out.println("Enter 6 - To Add a race  ");
                    System.out.println("Enter 7 - To Save Data in a File ");
                    System.out.println("Enter 8 - To Exit the Program  ");
                    System.out.println("Enter the number of you choice ");
                    u_input = input.nextLine();
                    System.out.println("----------------------------------------------------------------------");


            if (u_input.equals("1")) {
               createDriver();
            }else if (u_input.equals("2")){
                removeDriver();
            }else if (u_input.equals("3")){
                changeDriver();
            }else if (u_input.equals("4")){
                driverStats();
            }else if (u_input.equals("5")){
                driverTable();
            }else if (u_input.equals("6")){
                addRace();
            }else if (u_input.equals("7")){
                storeData();
            }else if (u_input.equals("8")){
                System.out.println("Exiting the program");
                cont = false;
            }else {
                cont=true;
                System.out.println("Error");
                System.out.println("Pleas try again");
            }
        }
    }
}
