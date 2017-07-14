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
public class CreditCard extends Payment {

    public String creditCardNum;
    public String cVV;
    public String expDate;
    public String paymentComplete;

    @Override
    public String generatePayment(String a, String b, String c){

        return paymentComplete;
    }

    public String getCreditCardNum() {
        System.out.println("Please enter your credit card number");
        creditCardNum = scan.nextLine();

        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getcVV() {

        System.out.println("Please enter your CVV");
        cVV = scan.nextLine();
        return cVV;

    }

    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    public String getExpDate() {
        System.out.println("Please enter your Exp Date");
        expDate = scan.nextLine();
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getPaymentComplete() {
        return paymentComplete;
    }

    public void setPaymentComplete(String paymentComplete) {
        this.paymentComplete = paymentComplete;
    }
}
