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

public abstract class Payment {

    Scanner scan = new Scanner(System.in);
    OOValidator validator = new OOValidator();

    /**
     * @param subTotal
     * @return
     */
    public double getgrandtotal(double subTotal) {
        double grandTotal = subTotal + (subTotal * 0.06);
        return grandTotal;
    }

    /**
     * @param price
     * @param quantity
     * @param index
     * @return
     */
    public double linetotal(HashMap<Integer, String> price, HashMap<Integer, String> quantity, int index) {
        double lineTotal = 0;
        lineTotal += Double.parseDouble(price.get(index)) * Double.parseDouble(quantity.get(index));
        return lineTotal;
    }

    /**
     * @param price
     * @param quantity
     * @return
     */
    public double subtotal(HashMap<Integer, String> price, HashMap<Integer, String> quantity) {
        double subTotal = 0;

        for (int Key : price.keySet()) {
            subTotal += Double.parseDouble(price.get(Key)) * Double.parseDouble(quantity.get(Key));
        }
        return subTotal;
    }


    /**
     * @param i
     * @return
     */
    public double generatePayment(double i) {
        return 0;
    }

    /**
     * @param creditNum
     * @param cVV
     * @param expDate
     * @return
     */
    public String generatePayment(String creditNum, String cVV, String expDate) {
        return null;
    }

    /**
     * @param d
     * @return
     */
    public String generatePayment(String d) {

        return null;
    }


}
