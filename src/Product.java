import java.io.*;
import java.util.Scanner;

/**
 * Created by michaelgleeson on 7/12/17.
 */
public class Product {

    public static void readFromFile() {
        try {
            File myFile = new File("menu.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);
            String line;
            while ((line = buff.readLine()) != null) {
                System.out.println(line);
            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeToFile() {
        // write to file
        try {
            Scanner scnr = new Scanner(System.in);
            FileWriter writer = new FileWriter("menu.txt", true);
            writer.write("Cheeseburger" + "\n");
            writer.close();
//            if (!Validation.duplicateCountry(userCountry)) {
//
//            }else {
//                System.out.println("Country already in list!");
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
