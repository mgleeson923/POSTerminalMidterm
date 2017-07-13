import java.util.Scanner;

/**
 * Created by vernonscott on 7/13/17.
 */
public class CreditCard extends Payment {
    Scanner scan= new Scanner(System.in);


    private String creditCardNum;
    private String cVV;
    private String expDate;

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
}
