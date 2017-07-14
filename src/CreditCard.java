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
public abstract class CreditCard extends Payment {



    public String creditCardNum;
    public String cVV;
    public String expDate;
    public String paymentComplete;

    @Override
    public String generatePayment(String a, String b, String c){

        return paymentComplete;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getcVV() {
        return cVV;
    }

    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    public String getExpDate() {
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
