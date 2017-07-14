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

    public HashMap<Integer, String> mapName = new HashMap<>();
    public HashMap<Integer, String> mapCategory = new HashMap<>();
    public HashMap<Integer, String> mapDescription = new HashMap<>();
    public HashMap<Integer, String> mapPrice = new HashMap<>();
    private String name[] = new String[12];
    private String category[] = new String[12];
    private String description[] = new String[12];
    private String price[] = new String[12];
    private String menuLine[] = new String[12];
    private int quantity;
    private int productID;
    public ArrayList<String> products = new ArrayList<>();
    ArrayList<Product> shoppingCart = new ArrayList<>();

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // default constructor
    public Product() {

    }

    public ArrayList<String> createMenu(int showOutput) {
        /*
        Creates menu of items from a text file called menu.txt.
        Returns an ArrayList of Strings called name, category, description, price
         */
        String line;
        int j = 0;

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
            //System.out.println(mapName.size() + " " + mapCategory.size() + " " + mapDescription.size() + " " + mapPrice.size() );
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


//        }

        }
        return products;
    }// end method


//    public ArrayList<Product> getItem() {
//        Scanner scnr = new Scanner(System.in);
//        String repeat;
//        do {
//            System.out.print("Please enter the item you would like to add to your order: ");
//            int userItem = scnr.nextInt();
//
//            System.out.println("How many would you like?");
//            int itemQuantity = scnr.nextInt();
//
//            Product prod = new Product();
//            prod.setQuantity(itemQuantity);
//            prod.setProductID(userItem);
//            shoppingCart.add(prod);
//
//            System.out.println("Would you like to add another item? Y/N: ");
//            scnr.nextLine();
//            repeat = scnr.nextLine();
//        } while (repeat.equalsIgnoreCase("y"));
//
//        return shoppingCart;
//    } // end method
//
//    public ArrayList<String> getCart() {
//        String line;
//
//        try {
//            File myFile = new File("cart.txt");
//            FileReader reader = new FileReader(myFile);
//            BufferedReader buff = new BufferedReader(reader);
//
//            while ((line = buff.readLine()) != null) {
//                System.out.println(line);
//                products.add(line);
//            }
//            buff.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return products;
//    }// end method

//    @Override
//    public String toString() {
//        for (int i = 0; i < name.length; i++) {
//            System.out.println(name[i]);
//            System.out.println(category[i]);
//            System.out.println(description[i]);
//            System.out.println(price[i]);
//        }
//        return products.toString();
//    }// end method


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

