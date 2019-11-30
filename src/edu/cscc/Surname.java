package edu.cscc;

import java.io.Serializable;

/**
 * @author Bobby Linse
 * Description: Create a Java class called Surname that holds a surname, the frequency of that surname (not cumulative
 * frequency), and the rank of the surname.
 *
 * Java II
 * Instructor: David Palzer
 * CSCC - NW
 * November 2019
 *
 */

public class Surname implements java.io.Serializable {
    private String surname;
    private double frequency;
    private int rank;

    //Constructor
    public Surname(String surname, double frequency, int rank) {
        this.surname = surname;
        this.frequency = frequency;
        this.rank = rank;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
