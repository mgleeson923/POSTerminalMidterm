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

public class Cash extends Payment {
    // private double cashReceived;
    public double changeGiven;

    @Override
    public double generatePayment(double i) {
        return changeGiven;
    }

    /**
     * @param sc
     * @return
     */
    public double getCashReceived(Scanner sc) {

        double cashReceived = validator.getDouble(sc, "Please enter your total amount of cash: ");
        return cashReceived;
    }

    /**
     * @param cashReceived
     * @param subtotal
     * @return
     */
    public double getChangeGiven(double cashReceived, double subtotal) {
        changeGiven = cashReceived - subtotal;
        return changeGiven;
    }


}
