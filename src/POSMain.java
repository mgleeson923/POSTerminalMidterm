import java.util.HashMap;
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

public class POSMain {

    public static void main(String[] args) {
        System.out.println("Welcome to M3V! My Name is Jarvis, How can I serve you? ");

        int sizeOfCart = 0;
        boolean cont = true;
        int caseNumber;
        int quantity;
        int payOption;
        Scanner scnr = new Scanner(System.in);
        OOValidator validator = new OOValidator();
        Product menu = new Product();
        Product cart = new Product();
        //menu.createMenu(0);

        System.out.println("POS Terminal Console");

        while (cont) {
            caseNumber = validator.getInt(scnr, "1: View Menu\n2: Add Item to Cart\n3: View Cart\n4: Checkout\n", 1, 4);
            switch (caseNumber) {
                case 1:
                    menu.createMenu(0);
                    System.out.println("---------------------------");
                    break;
                case 2:
                    //System.out.println("What Line Number?");
                    sizeOfCart = validator.getInt(scnr, "What Line Number?: ");
                    //System.out.println("How Many?");
                    quantity = validator.getInt(scnr, "How Many: ");
                    ;
                    String menuItemtoAdd = menu.mapName.get(sizeOfCart);
                    String menuPricetoAdd = menu.mapPrice.get(sizeOfCart);
                    cart.mapName.put(sizeOfCart, menuItemtoAdd);
                    cart.mapPrice.put(sizeOfCart, menuPricetoAdd);
                    cart.mapQuantity.put(sizeOfCart, Integer.toString(quantity));
                    System.out.println("---------------------------");
                    break;
                case 3:
                    System.out.println("New Cart is \n" + cart.toString());
                    System.out.println("---------------------------");
                    break;
                case 4:
                    System.out.println("How would you like to pay?");
                    payOption = validator.getInt(scnr, "1: Cash\n2: Credit Card\n3: Check\n", 1, 3);
                    paymentSwitch(payOption, cart.mapPrice, cart.mapQuantity, scnr);
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void paymentSwitch(int payOption, HashMap<Integer, String> cartPayment, HashMap<Integer, String> quantity, Scanner scnr) {
        switch (payOption) {
            case 1:
                Cash cash = new Cash();
                System.out.println("Amount Due:");
                double subtotal = cash.subtotal(cartPayment, quantity);
                System.out.printf("%.2f", subtotal);
                System.out.println();
                double cashReceived = cash.getCashReceived(scnr);
                double change = cash.getChangeGiven(cashReceived, subtotal);
                System.out.printf("Change: " + "%.2f", change);

                break;
            case 2:
                CreditCard cc = new CreditCard();
                subtotal = cc.subtotal(cartPayment, quantity);
                System.out.println(subtotal);
                cc.getCreditCardNum();
                cc.getcVV();
                cc.getExpDate();
                System.out.println("Thank you for your payment");
                break;
            case 3:
                Check check = new Check();
                check.getCheckNum();
                System.out.println("Thank you for your payment");
                break;
        }

    }
}
