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
 *
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
            caseNumber = validator.getIntWithinRange("1: View Menu\n2: Add Item to Cart\n3: View Cart\n4: Checkout\n", 1, 4);
            switch (caseNumber) {
                case 1:
                    menu.createMenu(0);
                    break;
                case 2:
                    System.out.println("What Line Number?");
                    sizeOfCart = scnr.nextInt();
                    System.out.println("How Many?");
                    quantity = scnr.nextInt();
                    String menuItemtoAdd = menu.mapName.get(sizeOfCart);
                    String menuPricetoAdd = menu.mapPrice.get(sizeOfCart);
                    cart.mapName.put(sizeOfCart, menuItemtoAdd);
                    cart.mapPrice.put(sizeOfCart, menuPricetoAdd);
                    cart.mapQuantity.put(sizeOfCart, Integer.toString(quantity));
                    break;
                case 3:
                    System.out.println("New Cart is \n" + cart.toString());
                    break;
                case 4:
                    System.out.println("How would you like to pay?");
                    payOption = validator.getIntWithinRange("1: Cash\n2: Credit Card\n3: Check\n", 1, 3);
                    paymentSwitch(payOption);
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void paymentSwitch(int payOption) {
        switch (payOption) {
            case 1:
                Cash cash = new Cash();
                System.out.println("Amount Due:");
                break;
            case 2:
                CreditCard cc = new CreditCard();
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
