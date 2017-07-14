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

    public HashMap<Integer, String> getMapName() {

        return mapName;
    }

    public HashMap<Integer, String> getMapPrice() {
        return mapPrice;
    }

    public HashMap<Integer, String> mapName = new HashMap<>();
    public HashMap<Integer, String> mapCategory = new HashMap<>();
    public HashMap<Integer, String> mapDescription = new HashMap<>();
    public HashMap<Integer, String> mapPrice = new HashMap<>();
    public HashMap<Integer, String> mapQuantity = new HashMap<>();

    // default constructor
    public Product() {

    }

    public ArrayList<HashMap<Integer, String>> createMenu(int showOutput) {
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

                populateMenu(line, counter, comma, startLocation, commaCount);
                counter++;
            }
            buff.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        printMenu();

        ArrayList<HashMap<Integer, String>> productListFromMenu = new ArrayList<>();
        productListFromMenu.add(mapName);
        productListFromMenu.add(mapPrice);

        return productListFromMenu;
    } // end method

    public void populateMenu(String line, int counter, char comma, int startLocation, int commaCount) {
        int commaLocation;
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
    }

    public void printMenu() {
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
    }


    @Override
    public String toString() {

        return " " + mapName + " " + mapPrice + " " + mapQuantity;
    }
} // end class

