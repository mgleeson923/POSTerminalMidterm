/**
 * Created by vernonscott on 7/13/17.
 */
public class Cash extends Payment {
    private double cashReceived;
    public double changeGiven;

    @Override
     public double generatePayment(double i){

        return changeGiven;
    }

    public double takePayment() {

        return changeGiven;
    }

    public double getCashReceived() {
        return getCashReceived();
    }

    public void setCashRecieved(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public double getChangeGiven(double totalPayment,double grandTotal) {
        return changeGiven;// totalPayment-grandTotal
    }

    public void setChangeGiven(double changeGiven) {
        this.changeGiven = changeGiven;
    }



}
