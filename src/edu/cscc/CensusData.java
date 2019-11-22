package edu.cscc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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

public class CensusData {

    public static void main(String args[]) {

        String contents = getUrlContents("https://www2.census.gov/topics/genealogy/1990surnames/dist.all.last");
        System.out.println(contents);
    }

    public static void serializeData(){

    }

    private static String getUrlContents(String urlString)
    {
        StringBuilder content = new StringBuilder();

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try
        {
            // create a url object
            URL url = new URL(urlString);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }


        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }


}
