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
public class Check extends Payment {
    private String checkNum;
    public String checkAccepted;

    @Override
    public  String generatePayment(String d){

        return checkAccepted;
    }


    public String getCheckNum() {

        System.out.println("Enter Check #");
        checkNum = scan.nextLine();
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
