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
public class Check extends Payment {
    private String checkNum;
    public String checkAccepted;

    @Override
    public String generatePayment(String d) {

        return checkAccepted;
    }


    public String getCheckNum() {

        System.out.print("Please enter your 9 digit checking account number: ");
        checkNum = scan.nextLine();
        while ((checkNum.length() < 9) || (checkNum.length() > 9)) {
            System.out.print("Invalid checking number, Please enter a valid 9 digit checking account number: ");
            checkNum = scan.nextLine();
        }
        return checkNum;
    }

    public void setCheckNum() {
        this.checkNum = checkNum;
    }


    public String getCheckAccepted() {
        return checkAccepted;
    }

    public void setCheckAccepted(String checkAccepted) {
        this.checkAccepted = checkAccepted;
    }

}
