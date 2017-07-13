import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Midterm Project Grand Circus
 *
 * Java June 2017
 *
 * (Alphabetical Order)
 * Michael Gleeson
 * Matthew Menna
 * Mark Ritter
 * Vernon Scott
 *
 */

public class Map {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> m1 = new HashMap<Integer, String>();

        BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
        String line = "";
        int i = 0;

        while (line != null) {
            line = br.readLine();
            m1.put(i, line);
            i++;
        }
        for (int j = 0; j < m1.size(); j++) {
            System.out.println(m1.get(j));
        }
//        m1.put(1, "Cheeseburger,meal,simple burger,$3.79");
//        m1.put(2, THESE NEED TO BE OBJECTS );
//        m1.put(3, );
//        m1.put(4, );
//        m1.put(5, );
//        m1.put(6, );
//        m1.put(7, );
//        m1.put(8, );
//        m1.put(9, );
//        m1.put(10, );
//        m1.put(11, );
//        m1.put(12, );
//        System.out.println(m1.get(1));
//
//    }
//    public ArrayList<String> createMenu(int showOutput) {
//        String line;
//
//        try {
//            File myFile = new File("menu.txt");
//            FileReader reader = new FileReader(myFile);
//            BufferedReader buff = new BufferedReader(reader);
//
//            while ((line = buff.readLine()) != null) {
//                if (showOutput == 1) {
//                    System.out.println(line);
//                }
//                products.add(line);
//            }
//            buff.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return products;
//    }


    }
}
