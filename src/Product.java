import java.io.*;
import java.util.ArrayList;

/**
 * Created by michaelgleeson on 7/12/17.
 */
public class Product {

    private String name;
    private String category;
    private String description;
    private double price;
    public ArrayList<String> products = new ArrayList<>();

    public Product() {

    }

    public ArrayList<String> createMenu(int showOutput) {
        String line;

        try {
            File myFile = new File("menu.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);

            while ((line = buff.readLine()) != null) {
                if (showOutput == 1) {
                    System.out.println(line);
                }
                products.add(line);
            }
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        return products.toString();
    }


    private static void ReadFromFile() {
        try {
            File myFile = new File("menu.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader buff = new BufferedReader(reader);
            String line = null;
            while ((line = buff.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void WriteToFile() {
        try {
            FileWriter writer = new FileWriter("menu.txt", true);
            writer.write("Iced Tea Drink Sweetened Tea $0.99 \n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

