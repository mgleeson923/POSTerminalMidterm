import java.util.Scanner;

/**
 * Created by vernonscott on 7/13/17.
 */
public class Check extends Payment {
    Scanner scan=new Scanner(System.in);

    private String checkNum;


    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

}
