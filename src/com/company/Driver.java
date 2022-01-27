package com.company;

import java.io.Serializable;
import java.io.Externalizable;

public abstract class Driver implements Serializable {

    public String driver_fullName;
    public   String driver_location;
    public   String  driver_team;

    public Driver(String driver_fullName, String driver_location, String driver_team){
        this.driver_fullName     = driver_fullName ;
        this.driver_location     = driver_location ;
        this.driver_team         = driver_team ;
    }

    //public abstract int countPoints(int p);

}
