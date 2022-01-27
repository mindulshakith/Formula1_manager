package com.company;

import java.io.Serializable;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.newline;

public class Formula1Driver extends Driver implements Serializable {

    public int firstplaces;
    public int secondplaces;
    public int thirdplaces;
    public int numOfRaces;
    public int points;

    public Formula1Driver(String driver_fullName, String driver_location, String driver_team , int firstplaces, int secondplaces, int thirdplaces, int numOfRaces, int points) {
        super(driver_fullName, driver_location, driver_team);
        this.firstplaces =firstplaces;
        this.secondplaces=secondplaces;
        this.thirdplaces =thirdplaces;
        this.numOfRaces  =numOfRaces;
        this.points      =points;
    }

    @Override
    public String toString() {
        return
                "----------------------------------------------------"+"\n"+
                "Driver Name            :" + driver_fullName + "\n" +
                "driver location        :" + driver_location + '\n' +
                "driver team            :" + driver_team     + '\n' +
                "Number of firstplaces  :" + firstplaces     + '\n' +
                "Number of secondplaces :" + secondplaces    + '\n' +
                "Number of thirdplaces  :" + thirdplaces     + '\n' +
                "Number of numOfRaces   :" + numOfRaces      + '\n' +
                "Number of points       :" + points
                ;
    }

    /*getters and setters
    public int firstplaces() {
        return firstplaces;
    }

    public void setFirstplaces(int firstplaces) {
        this.firstplaces = firstplaces;
    }

    public int secondplaces() {
        return secondplaces;
    }

    public void setSecondplaces(int secondplaces) {
        this.secondplaces = secondplaces;
    }

    public int thirdplaces() {
        return thirdplaces;
    }

    public void setThirdplaces(int thirdplaces) {
        this.thirdplaces = thirdplaces;
    }

    public int numOfRaces() {
        return numOfRaces;
    }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces = numOfRaces;
    }

    public int points() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }*/
}
