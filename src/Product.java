import java.io.*;
import java.util.ArrayList;

/**
 * Created by michaelgleeson on 7/12/17.
 */
public class Product {

    private String name[] = new String[12];
    private String tempName;
    private String category[] = new String[12];
    private String description[] = new String[12];
    private String price[] = new String[12];
    private String menuLine[] = new String[12];
    public ArrayList<String> products = new ArrayList<>();

    public Product() {

    }

    public ArrayList<String> createMenu(int showOutput) {
        String line;
        int j = 0;

        try {
            File myFile = new File("menu.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);

            while ((line = buff.readLine()) != null) {
                menuLine = line.split(",");

                for (int i = 0; i < menuLine.length; i++) {
                    if (i == 0) {
                         name[j] = menuLine[i];
                    } else if (i == 1) {
                        category[j] = menuLine[i];
                    }else if (i == 2) {
                        description[j] = menuLine[i];
                    }else if (i == 3) {
                        price[j] = menuLine[i];
                    }
                }j++;

            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i <name.length ; i++) {
            System.out.println(name[i]);
            System.out.println(category[i]);
            System.out.println(description[i]);
            System.out.println(price[i]);
        }
        return products;
    }


    public ArrayList<String> getItem(int lineNumber) {
        String line;

        try {
            File myFile = new File("menu.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);

            for (int i = 0; i <= products.size(); i++) {
                line = buff.readLine();
                if (i == (lineNumber - 1)) {
                    products.add(line);
                }
            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public ArrayList<String> getCart() {
        String line;

        try {
            File myFile = new File("cart.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);

            while ((line = buff.readLine()) != null) {
                System.out.println(line);
                products.add(line);
            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
  public String toString() {
        for (int i = 0; i <name.length ; i++) {
            System.out.println(name[i]);
            System.out.println(category[i]);
            System.out.println(description[i]);
            System.out.println(price[i]);
        }
       return products.toString();
   }


//    private static void ReadFromFile() {
//        try {
//            File myFile = new File("menu.txt");
//            FileReader reader = new FileReader(myFile);
//            BufferedReader buff = new BufferedReader(reader);
//            String line = null;
//            while ((line = buff.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void WriteToFile() {
//        try {
//            FileWriter writer = new FileWriter("menu.txt", true);
//            writer.write("Iced Tea Drink Sweetened Tea $0.99 \n");
//            writer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

