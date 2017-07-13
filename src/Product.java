import java.io.*;
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

public class Product {

// declare variables

        private String name[] = new String[12];
        private String tempName;
        private String category[] = new String[12];
        private String description[] = new String[12];
        private String price[] = new String[12];
        private String menuLine[] = new String[12];
        public ArrayList<String> products = new ArrayList<>();

        // default constructor
    public Product() {

        }

        public ArrayList<String> createMenu ( int showOutput){
        /*
        Creates menu of items from a text file called menu.txt.
        Returns an ArrayList of Strings called name, category, description, price
         */
<<<<<<< HEAD
            String line;
            int j = 0;

            try {
                File myFile = new File("menu.txt");
                FileReader reader = new FileReader(myFile);


                BufferedReader buff = new BufferedReader(reader);

                while ((line = buff.readLine()) != null) {
                    //menuLine = line.split(",");
                    String[] menuLine = line.split(",");
                    for (int i = 0; i < menuLine.length; i++) {
                        if (i == 0) {
                            name[j] = menuLine[i];
                        } else if (i == 1) {
                            category[j] = menuLine[i];
                        } else if (i == 2) {
                            description[j] = menuLine[i];
                        } else if (i == 3) {
                            price[j] = menuLine[i];
                        }
=======
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
                    }else if (i == 2) {
                        description[j] = menuLine[i];
                    }else if (i == 3) {
                        price[j] = menuLine[i];
>>>>>>> b685f7da35f3ba4510753a39d2ae31b65357c225
                    }
                    j++;

                }
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
<<<<<<< HEAD
            for (int i = 0; i < name.length; i++) {
                System.out.println(name[i]);
                System.out.println(category[i]);
                System.out.println(description[i]);
                System.out.println(price[i]);
            }
            return products;
        } // end method
=======
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i <name.length ; i++) {
            System.out.println(name[i] + " " + price[i]);
            System.out.println(category[i] + " " + description[i]);
            System.out.println();
//            System.out.println(description[i]);
//            System.out.println(price[i]);
        }
        return products;
    } // end method
>>>>>>> b685f7da35f3ba4510753a39d2ae31b65357c225


        public ArrayList<String> getItem ( int lineNumber){
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
        } // end method

        public ArrayList<String> getCart () {
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
        public String toString () {
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

