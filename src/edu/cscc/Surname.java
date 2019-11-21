package edu.cscc;

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

public class Surname {

    private static String surname;
    private static int nameFreq;
    private static int nameRank;

    public Surname(String inSurname) {
        surname = inSurname;
     //   nameFreq = getNameFreq();
     //   nameRank = getNameRank();
        nameFreq = 0;
        nameRank = 0;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        Surname.surname = surname;
    }

    public int getNameFreq() {
        return nameFreq;
    }

    public void setNameFreq(int nameFreq) {
        Surname.nameFreq = nameFreq;
    }

    public int getNameRank() {
        return nameRank;
    }

    public void setNameRank(int nameRank) {
        Surname.nameRank = nameRank;
    }


}
