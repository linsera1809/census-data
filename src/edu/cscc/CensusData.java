package edu.cscc;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;


/**
 * @author Bobby Linse
 * Description: Create a Java class with a main method called CensusData. This class will read data from the URL above.
 * It will use each row of the Census data file to instantiate a Surname object. That Surname object will
 * then be added to a HashMap collection using the surname string as a key.
 *
 * Finally, after the HashMap is fully populated, it will be serialized into a local file named “./surname.dat”.
 *
 *  Java II
 *  Instructor: David Palzer
 *  CSCC - NW
 *  November 2019
 */

public class CensusData implements Serializable {

    public static void main(String[] args) throws IOException {
        try {
            HashMap<String, Surname> censusData = new HashMap<>();
            getUrlContents(censusData);
        }
        catch (ArrayIndexOutOfBoundsException aio) {
            aio.printStackTrace();
        }

    }

    private static void getUrlContents(HashMap<String, Surname> data) throws IOException {
        URL link = new URL("https://www2.census.gov/topics/genealogy/1990surnames/dist.all.last");
        URLConnection urlConnection = link.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())) ;

        String line = null;
        String regexPattern = "[ ]+";

        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(regexPattern);

            if((!info[0].equals(null)) && (!info[1].equals(null)) && (!info[3].equals(null))) {

                System.out.println("\n\nName: " + info[0] +
                        " \nFrequency: " + info[1] +
                        " \nRank: " + info[3]);

                data.put(info[0], new Surname(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[3])));
            }
        }

        bufferedReader.close();
        ObjectOutputStream outputFile = new ObjectOutputStream((new FileOutputStream("./surname.dat")));
        outputFile.writeObject(data);
        outputFile.close();

    }


}
