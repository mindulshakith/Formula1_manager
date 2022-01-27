package com.company;

import java.util.Comparator;

public class sortbyPoints implements Comparator<Formula1Driver> {//to create a custom sort method
    public int compare(Formula1Driver a, Formula1Driver b) {

        if (a.points == b.points) {
            if (a.firstplaces< b.firstplaces){
                return 1;
            }else {
                return -1;
            }
        }
        else if (a.points < b.points) {
            return 1;
        }
        else {
            return -1;
        }
    }
}