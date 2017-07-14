import java.util.HashMap;
import java.util.Scanner;

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
 */

public abstract class Payment {

    Scanner scan= new Scanner(System.in);
    OOValidator validator = new OOValidator();

    public double getgrandtotal(double subTotal){
        double grandTotal = subTotal + (subTotal * 0.06);
        return grandTotal;
    }

    public double linetotal(HashMap<Integer, String> price, HashMap<Integer, String> quantity, int index){
        double lineTotal = 0;
        lineTotal += Double.parseDouble(price.get(index)) * Double.parseDouble(quantity.get(index));
        return lineTotal;
    }

    public double subtotal(HashMap<Integer, String> price, HashMap<Integer, String> quantity) {
        double subTotal = 0;

        for (int Key : price.keySet()) {
            subTotal += Double.parseDouble(price.get(Key)) * Double.parseDouble(quantity.get(Key));
        }
        return subTotal;
    }


    public double generatePayment (double i){
        return 0;
    }

    public String generatePayment (String creditNum, String cVV, String expDate){
        return null;
    }

    public String generatePayment (String d){

        return null;
    }



}
