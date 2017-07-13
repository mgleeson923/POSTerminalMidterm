import java.io.*;
import java.util.ArrayList;
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

            while ((line = buff.readLine()) != null) {
                menuLine = line.split(",");

                for (int i = 0; i < 4; i++) {
                    if (i == 0) {
                        name[j] = menuLine[i];
                    } else if (i == 1) {
                        category[j] = menuLine[i];
                    } else if (i == 2) {
                        description[j] = menuLine[i];
                    } else if (i == 3) {
                        price[j] = menuLine[i];
                    }
                }
                j++;

            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < name.length; i++) {
            System.out.println((i + 1) + " " + name[i] + " " + price[i]);
            System.out.println(category[i] + " " + description[i]);
            System.out.println();
//            System.out.println(description[i]);
//            System.out.println(price[i]);
        }
        return products;
    } // end method


    public ArrayList<Product> getItem() {
        Scanner scnr = new Scanner(System.in);
        String repeat;
        do {
            System.out.print("Please enter the item you would like to add to your order: ");
            int userItem = scnr.nextInt();

            System.out.println("How many would you like?");
            int itemQuantity = scnr.nextInt();

            Product prod = new Product();
            prod.setQuantity(itemQuantity);
            prod.setProductID(userItem);
            shoppingCart.add(prod);

            System.out.println("Would you like to add another item? Y/N: ");
            scnr.nextLine();
            repeat = scnr.nextLine();
        }while (repeat.equalsIgnoreCase("y"));

        return shoppingCart;
    } // end method

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
    }// end method

    @Override
    public String toString() {
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
            System.out.println(category[i]);
            System.out.println(description[i]);
            System.out.println(price[i]);
        }
        return products.toString();
    }// end method


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

