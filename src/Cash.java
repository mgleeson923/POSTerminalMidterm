import java.util.Scanner;

/**
 * Created by vernonscott on 7/13/17.
 */
public class Cash extends Payment {
    Scanner scan= new Scanner(System.in);

    private double cashTaken;


    public double getCashTaken() {
        return cashTaken;
    }

    public void setCashTaken(double cashTaken) {
        this.cashTaken = cashTaken;
    }

    public double getChangeGiven() {
        return changeGiven;
    }

    public void setChangeGiven(double changeGiven) {
        this.changeGiven = changeGiven;
    }

    private double changeGiven;






}
