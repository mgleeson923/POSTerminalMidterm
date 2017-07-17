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
public class CreditCard extends Payment {


    public String creditCardNum;
    public String cVV;
    public String expDate;
    public String paymentComplete;

    @Override
    public String generatePayment(String a, String b, String c) {

        return paymentComplete;
    }

    /**
     * @return implements https://en.wikipedia.org/wiki/Luhn_algorithm
     */
    public String getCreditCardNum() {
        System.out.print("Please enter your credit card number: ");
        creditCardNum = scan.nextLine();

        while ((creditCardNum.length() > 16) || (creditCardNum.length() < 16)) {
            System.out.print("Invalid credit card number! Please enter a  valid 16 credit card number: ");
/*            while (creditCardNum > 0) {
                creditCardNum = creditCardNum / 10;
            }
*/
            creditCardNum = scan.nextLine();
        }

        return creditCardNum;


    }

    /**
     * @param creditCardNum
     */
    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    /**
     * @return
     */
    public String getcVV() {
        System.out.print("Please enter your CVV (located on the back of the card): ");
        cVV = scan.nextLine();

        while ((cVV.length() < 3) || (cVV.length() > 3)) {
            System.out.print("Invalid CVV! please enter a valid 3 digit CVV located on the back of your card: ");
            cVV = scan.nextLine();
        }
        return cVV;

    }

    /**
     * @param cVV
     */
    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    /**
     * @return
     */
    public String getExpDate() {
        System.out.println("Please enter your Exp Date (MMYY): ");
        expDate = scan.nextLine();
        while ((expDate.length() < 4) || (expDate.length() > 4)) {
            System.out.println("Invalid Expiration Date! Please enter the exp date in format MMYY");
            expDate = scan.nextLine();
        }
        return expDate;
    }

    /**
     * @param expDate
     */
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    /**
     * @return
     */
    public String getPaymentComplete() {
        return paymentComplete;
    }

    /**
     * @param paymentComplete
     */
    public void setPaymentComplete(String paymentComplete) {
        this.paymentComplete = paymentComplete;
    }
}
