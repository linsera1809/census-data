package edu.cscc;

import java.io.*;
import java.util.HashMap;
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

    public static void main(String[] args) {
        try {
            doLookup();
        }
        catch (IOException e ) {
            System.out.println("Something went wrong in reading surname.dat");
            e.printStackTrace();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found error");
            cnfe.printStackTrace();
        }

    }
    public static void doLookup() throws IOException, ClassNotFoundException {
        boolean programRunning = true;
        HashMap<String, Surname> surHash = new HashMap<String, Surname>();
        String inSur;
        Scanner in = new Scanner(System.in);

        FileInputStream fis = new FileInputStream("./surname.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        /**
         *  Line# 51 is needed to read objects into the hashmap, but is causing issues with
         *  NotSerializableExceptions & WriteAbortedExceptions.
         *
         *  Looking at documentation this is an issue with Serializable objects, but I have been
         *  unable to resolve it. To run everything else, comment out the line and uncomment line 60
         */
        surHash = (HashMap<String, Surname>) ois.readObject();

        // Comment out line# 63 after remedying error in line# 60
        //surHash = null;



        do {
            System.out.println("Enter a surname ('Quit' to exit)");
            inSur = in.next();

            if (inSur.toLowerCase().equals("quit")) {
                programRunning = false;

            } else if (!surHash.containsKey(inSur.toLowerCase())) {
                System.out.println("That name does not exist in the file!");

            } else {
                Surname toDisplay = surHash.get(inSur.toLowerCase());
                System.out.println("Surname is " + toDisplay.getSurname());
                System.out.println("Rank is " + toDisplay.getRank());
                System.out.println("Frequency is " + toDisplay.getFrequency());

            }
        } while(programRunning);

        ois.close();
        fis.close();
        in.close();
    }
}
