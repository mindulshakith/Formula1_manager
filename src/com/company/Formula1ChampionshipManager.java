package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;
import java.io.Serializable;
import java.util.Iterator;
import static com.company.ChampionshipManager.viewDriverDetails;

public class Formula1ChampionshipManager  {

    static Scanner input = new Scanner(System.in);

    public static ArrayList<Formula1Driver> fDriver = new ArrayList<>();//Arraylist to store Formula1Driver details


    //method to add a new driver
    public static void createDriver() {// creates a new driver
        String driverName;
        String driverLocation;
        String team;
        int numOf_1stPlaces = 0;
        int numOf_2ndPlaces = 0;
        int numOf_3rdPlaces = 0;
        int numOf_Races = 0;
        int points=0;

        boolean inputAccepted1 = false;
        boolean inputAccepted2 = false;
        boolean inputAccepted3 = false;
        boolean inputAccepted4 = false;
        boolean inputAccepted5 = false;

        System.out.println("Enter the Driver Name     : ");
        driverName = input.next();
        System.out.println("Enter the Driver Location : ");
        driverLocation = input.next();
        System.out.println("Enter the DriverTeam      : ");
        team = input.next();

        boolean race = false;
        while (race = true) {

            //if user inputs wrong type of command program will send a warning
            while (!inputAccepted1) {
                try {
                    System.out.println("Enter the Number of First Places : ");
                    numOf_1stPlaces = Integer.valueOf(input.next());
                    inputAccepted1 = true;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input Type!!!");
                }
            }

            //if user inputs wrong type of command program will send a warning
            while (!inputAccepted2) {
                try {
                    System.out.println("Enter the Number of Second Places : ");
                    numOf_2ndPlaces = Integer.valueOf(input.next());
                    inputAccepted2 = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input Type!!!");
                }
            }

            //if user inputs wrong type of command program will send a warning
            while (!inputAccepted3) {
                try {
                    System.out.println("Enter the Number of Third Places : ");
                    numOf_3rdPlaces = Integer.valueOf(input.next());
                    inputAccepted3 = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input Type!!!");
                }
            }

            while (!inputAccepted4){//to validate the number races
                try {
                    System.out.println("Enter Total number of Races : ");
                    numOf_Races = Integer.valueOf(input.next());
                    inputAccepted4=true;
                    break;
                }catch (Exception e){
                    System.out.println("Enter a valid integer value");
                }
            }



            //if at least addition of 1,2,3 places are less  than number of races it is possible user has entered wrong data
            if (numOf_1stPlaces + numOf_2ndPlaces + numOf_3rdPlaces > numOf_Races) {
                System.out.println("Data you Entered does not match the algorithm ");
                race = false;
                break;
            } else {
                race = true;
                break;
            }
        }

        while (!inputAccepted5){//to validate the number races
            try {
                System.out.println("Enter Current Points of the Driver : ");
                points = input.nextInt();
                inputAccepted5=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }

        //creating an array of objects
        fDriver.add(new Formula1Driver(driverName, driverLocation, team, numOf_1stPlaces,
                numOf_2ndPlaces, numOf_3rdPlaces, numOf_Races, points));

        storeData();
    }

    //method to remove a driver
    public static void removeDriver() {
        int removenum=0;
        boolean rmv=false;

        loadData();
        viewDriverDetails();
            try {
                System.out.println("Enter the Driver Number to remove : ");
                removenum = input.nextInt();

            }catch (Exception e){
                System.out.println("Error!!! Wrong input");
                removeDriver();
            }

        System.out.println("Successfully removed " + fDriver.get(removenum - 1).driver_fullName);
        fDriver.remove(removenum - 1);
        storeData();

        System.out.println("Updated driver Details");


    }

    //method to change driver from a constructer team
    public static void changeDriver() {

        int change = 0;
        String change_Name;
        int change_1stP=0;
        int change_2ndP=0;
        int change_3rdP=0;
        int change_numOfRaces=0;
        int change_Points=0;

        boolean c1=false;
        boolean c2=false;
        boolean c3=false;
        boolean c4=false;
        boolean c5=false;
        boolean c6=false;

        System.out.println("Select driver number");

        loadData();
        viewDriverDetails();

        while (!c1){//to validate the number of the diver
            try {
                System.out.println("Enter driver number to change name : ");
                change=input.nextInt();
                c1=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }

        System.out.println("Enter the name of the new driver");
        change_Name = input.next();

        while (!c2){//to validate number of first places
            try {
                System.out.println("Enter the number of first places of" + change_Name);
                change_1stP=input.nextInt();
                c2=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }

        while (!c3){//to validate number of second places
            try {
                System.out.println("Enter the number of second places of" + change_Name);
                change_2ndP=input.nextInt();
                c3=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }

        while (!c4){//to validate number of third places
            try {
                System.out.println("Enter the number of third places of" + change_Name);
                change_3rdP=input.nextInt();
                c4=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }

        while (!c5){//to validate number of races
            try {
                System.out.println("Enter the number of races of" + change_Name);
                change_numOfRaces=input.nextInt();
                c5=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }

        while (!c6){//to validate points
            try {
                System.out.println("Enter the number of points of" + change_Name);
                change_Points=input.nextInt();
                c6=true;
                break;
            }catch (Exception e){
                System.out.println("Enter a valid integer value");
            }
        }
        Formula1Driver changeObject = new Formula1Driver(change_Name, fDriver.get(change - 1).driver_location, fDriver.get(change - 1).driver_team,
                change_1stP, change_2ndP, change_3rdP, change_numOfRaces, change_Points);//create a object with updated driver details

        fDriver.set(change - 1, changeObject);//replacing updated object with the old one

        storeData();

    }

    //method to view stats of a specific driver
    public static void driverStats() {
        int selectDriver;
        System.out.println("Select a Driver");
        loadData();
        viewDriverDetails();

        System.out.println("Selct the driver number : ");
        selectDriver = input.nextInt();

        System.out.println(fDriver.get(selectDriver - 1));
    }

    //method to show every driver stats .drivers needs to be printed in descending order to points
    public static void driverTable() {
        loadData();
        Collections.sort(fDriver, new sortbyPoints());

        try {
            for (int i = 0; i < fDriver.size(); i++) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Driver " + (i + 1));
                System.out.println(fDriver.get(i));
                System.out.println("----------------------------------------------------------------------");

            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //method to add a new race and update driver details
    public static void addRace() {
        loadData();
        System.out.println("Date Format (dd/MMM/YYYY)");
        System.out.println("Enter the Race Date : ");
        String Date = input.next();
        int position;//position of the driver in the race
        ArrayList<Integer> inputPositions = new ArrayList<Integer>();
        boolean positionB=false;

        try {
            java.util.Date dataForm = new SimpleDateFormat("dd/MM/YYYY").parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Enter details relevent to the race at : " + Date);

        try {
            for (int i = 0; i <= fDriver.size(); i++) {
                System.out.println("Enter " + fDriver.get(i).driver_fullName + " Position");
                position = input.nextInt();
                inputPositions.add(position);

                while (!positionB) {
                    if (position==1) {
                        fDriver.get(i).firstplaces = fDriver.get(i).firstplaces + 1;
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 25;
                        storeData();
                        break;
                    } else if (position == 2) {
                        fDriver.get(i).secondplaces = fDriver.get(i).secondplaces + 1;
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 18;
                        storeData();
                        break;

                    } else if (position == 3) {
                        fDriver.get(i).thirdplaces = fDriver.get(i).thirdplaces + 1;
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 15;
                        storeData();
                        break;

                    } else if (position == 4) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 12;
                        storeData();
                        break;
                    } else if (position == 5) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 10;
                        storeData();
                        break;

                    } else if (position == 6) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 8;
                        storeData();
                        break;
                    } else if (position == 7) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 6;
                        storeData();
                        break;

                    } else if (position == 8) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 4;
                        storeData();
                        break;

                    } else if (position == 9) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 2;
                        storeData();
                        break;

                    } else if (position == 10) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        fDriver.get(i).points = fDriver.get(i).points + 1;
                        storeData();
                        break;

                    } else if (position == 11 || position == 12 || position == 13 || position == 14 ||
                            position == 15 || position == 16 || position == 17 || position == 18 ||
                            position == 19 || position == 20 || position == 21 || position == 22 ||
                            position == 23) {
                        fDriver.get(i).numOfRaces = fDriver.get(i).numOfRaces + 1;
                        storeData();
                        break;

                    } else {
                        System.out.println("Data you Entered is Invalid!!!");
                        positionB = true;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //method to view driver number,drivername and driver team.
    //this method is used to find the driver you want to make changes to
    public static void viewDriverDetails () {
        loadData();
            try {
                for (int i = 0; i <= fDriver.size(); i++) {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Driver " + (i + 1) + " : " + " Driver Name : " + fDriver.get(i).driver_fullName + " || " + " Driver Team : " + fDriver.get(i).driver_team);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("");
            }
        }

    //method to store data
    public static void storeData() {

            //write to file
            try{
                FileOutputStream writeData = new FileOutputStream("DriverDetails2.ser");
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                System.out.println("Saved Data");

                writeStream.writeObject(fDriver);
                writeStream.flush();
                writeStream.close();

            }catch (IOException e) {
                e.printStackTrace();
            }


    }

    //method to load data
    public static void loadData(){
        //deserialisation
        //this will load stored data from the file
        try{
            FileInputStream readData = new FileInputStream("DriverDetails2.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            //ArrayList<Formula1Driver> sss = (ArrayList<Formula1Driver>) readStream.readObject();
            fDriver=(ArrayList<Formula1Driver>) readStream.readObject();
            //System.out.println(fDriver.toString());

            readStream.close();

            //System.out.println(formula1Drivers.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //method to validate integer inputs
    public static int intValidate(int integer){
        boolean rmv = false;
        if (input.hasNextInt()){
            integer=input.nextInt();
        }else {
            System.out.println("Please Enter Valid Integer");
        }
        return integer;
    }




    }




