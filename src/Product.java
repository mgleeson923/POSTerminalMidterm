import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Midterm Project Grand Circus
 * <p>
 * Java June 2017
 * <p>
 * (Alphabetical Order)
 * Michael Gleeson
 * Matthew Menna
 * Mark Ritter
 * Vernon Scott
 */

public class Product {
// declare variables

    private HashMap<Integer, String> mapName = new HashMap<>();
    private HashMap<Integer, String> mapCategory = new HashMap<>();
    private HashMap<Integer, String> mapDescription = new HashMap<>();
    private HashMap<Integer, String> mapPrice = new HashMap<>();
    private ArrayList<String> products = new ArrayList<>();
    ArrayList<Product> shoppingCart = new ArrayList<>();


    // default constructor
    private Product() {

    }

    public ArrayList<String> createMenu(int showOutput) {
        /*
        Creates menu of items from a text file called menu.txt.
        Returns an ArrayList of Strings called name, category, description, price
         */
        String line;

        try {
            File myFile = new File("menu.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);

            int counter = 1;
            while ((line = buff.readLine()) != null) {

                char comma = ',';
                int commaLocation = 0;
                int startLocation = 0;
                int commaCount = 0;

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == comma && commaCount == 0) {
                        commaLocation = i;
                        mapName.put(counter, line.substring(startLocation, commaLocation));
                        commaCount++;
                        startLocation = commaLocation + 1;

                    } else if (line.charAt(i) == comma && commaCount == 1) {
                        commaLocation = i;
                        mapCategory.put(counter, line.substring(startLocation, commaLocation));
                        commaCount++;
                        startLocation = commaLocation + 1;
                    } else if (line.charAt(i) == comma && commaCount == 2) {
                        commaLocation = i;
                        mapDescription.put(counter, line.substring(startLocation, commaLocation));
                        commaCount++;
                        startLocation = commaLocation + 1;
                    } else if (commaCount == 3) {
                        commaLocation = i;
                        mapPrice.put(counter, line.substring(commaLocation, line.length()));
                        commaCount++;
                    }
                }
                counter++;
            }
            buff.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= mapName.size(); i++) {
            String s1 = "";
            String s2 = "";
            String s3 = "";
            String s4 = "";
            s1 = mapName.get(i);
            s2 = mapCategory.get(i);
            s3 = mapDescription.get(i);
            s4 = mapPrice.get(i);

            System.out.println(i + "\t" + s1 + "\t" + s2 + "\t" + s3 + "\t" + s4);

        }
        return products;
    }// end method

} // end class

