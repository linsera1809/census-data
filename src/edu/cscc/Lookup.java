package edu.cscc;


import java.util.Scanner;

/**
 * @author Bobby Linse
 * Description: Create a Java class with a main method called Lookup. This class will deserialize the previously created
 * file to re-create the HashMap containing the Surname objects.
 *
 * The Lookup class will then continuously query the user to enter a surname string.
 *
 * If the user supplied surname is in the HashMap, the program will print the surname, the surname frequency, and the surname rank.
 *
 * Otherwise it will inform the user that the surname is not in the list. The query should be case insensitive.
 * The program should terminate when the user enters ‘quit’.
 *
 *  Java II
 *  Instructor: David Palzer
 *  CSCC - NW
 *  November 2019
 */

public class Lookup {

    private static Surname surname = new Surname(null);

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        do{ //Run Program

            System.out.println("Please enter a surname, or 'quit' to exit");
            String inSurname = in.next();

            surname.setSurname(inSurname);
            int freq = surname.getNameFreq();
            int rank = surname.getNameRank();

            if(isProgramRunning()) {
                printResults(getSurnameString(), freq, rank);
            }

        }while( isProgramRunning() );

        in.close();

    }

    private static void deserializeHash() {
        // TODO
        // deserialize ,dat
        // recreate HashMap
        // return census data
    }

    private static String getSurnameString() {
        return surname.getSurname();
    }

    private static boolean isProgramRunning(){
        String keyword = getSurnameString();

        if(keyword.toLowerCase().equals("quit")) {
            return false;
        }
        else {
            return true;
        }
    }

    private static void printResults(String inSurname, int freq, int rank){
        System.out.println("The results for "+inSurname.toUpperCase()+" are: ");
        System.out.println("Frequency: "+freq);
        System.out.println("Rank: "+rank);
    }

}
