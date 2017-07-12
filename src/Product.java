import java.io.*;

/**
 * Created by michaelgleeson on 7/12/17.
 */
public class Product {

    private static void ReadFromFile() {
        try {
            //read from a file
            File myFile = new File("menu.txt");

            //FileReader is a connection stream for characters that connects to a text file
            FileReader reader = new FileReader(myFile);

            //BufferReader allows the FileReader to chain to it
            //it only goes back to check the file once the buffer is empty
            BufferedReader buff = new BufferedReader(reader);

            //declare a String variable to hold each line as it's read from the file
            String line = null;

            // While loop (Read a line of text and assign it to "line"
            //while that variable is NOT null, keep printing lines
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
        //write to file
        try {
            FileWriter writer = new FileWriter("menu.txt", true);
            writer.write("Iced Tea Drink Sweetened Tea $0.99 \n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

