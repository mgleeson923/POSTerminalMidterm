import java.util.Scanner;

/**
 * Created by vernonscott on 7/13/17.
 */
public class Check extends Payment {
    private String checkNum;
    public String checkAccepted;

    @Override
    public  String generatePayment(String d){

        return checkAccepted;
    }


    public String getCheckNum() {
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
