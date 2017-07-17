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
 *
 * JavaDOC located at JavaDocPostTerminalMidterm/index.html in Repo
 *
 */

public class POSMain {

    public static void main(String[] args) {
        System.out.println("Welcome to M3V! My Name is Jarvis, how may I serve you? ");
        System.out.println("POS Terminal Console");

        //Variables for Cart, Validation, and Payment Choices
        int sizeOfCart;
        boolean cont = true;
        int caseNumber;
        int quantity;
        int payOption;
        Scanner scnr = new Scanner(System.in);
        OOValidator validator = new OOValidator();
        Product menu = new Product();
        Product cart = new Product();

        //Switch Case (with Validation), prompting the user on which option they would like to select first
        while (cont) {
            caseNumber = validator.getInt(scnr, "1: View Menu\n2: Add Item to Cart\n3: View Cart\n4: Checkout\n5: Clear Cart\n", 1, 5);
            switch (caseNumber) {

                //creates menu
                case 1:
                    menu.createMenu(0);
                    System.out.println("---------------------------");
                    break;

                //generates cart
                case 2:
                    sizeOfCart = validator.getInt(scnr, "Please enter the number of the item you wish to add to order: ");
                    while (sizeOfCart == 10) {
                        //System.out.println("Sorry, our Ice Cream Machine is currently out of order. Please select another item: ");
                        sizeOfCart = validator.getInt(scnr, "Sorry, our Ice Cream Machine is currently out of order. Please select another item: ");
                    }
                    quantity = validator.getInt(scnr, "How many would you like?: ");
                    String menuItemtoAdd = menu.mapName.get(sizeOfCart);
                    String menuPricetoAdd = menu.mapPrice.get(sizeOfCart);
                    cart.mapName.put(sizeOfCart, menuItemtoAdd);
                    cart.mapPrice.put(sizeOfCart, menuPricetoAdd);
                    cart.mapQuantity.put(sizeOfCart, Integer.toString(quantity));
                    System.out.println("---------------------------");
                    break;

                //Cart viewer with Quantity, Item, Price, and Line Total and Grand Total
                case 3:
                    System.out.println("Your Current Order is: \n");
                    double cartTotal = 0;
                    for (int Key : cart.mapName.keySet()) {
                        cart.mapLineTotal.put(Key, Double.parseDouble(cart.mapPrice.get(Key)) * Double.parseDouble(cart.mapQuantity.get(Key)));
                        System.out.printf("Quantity: " + cart.mapQuantity.get(Key) + " " + cart.mapName.get(Key));
                        System.out.println();
                        System.out.printf("Price: $" + cart.mapPrice.get(Key) + " $" + "%.2f", cart.mapLineTotal.get(Key));
                        cartTotal += cart.mapLineTotal.get(Key);
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println("Total: $" + cartTotal);
                    System.out.println("---------------------------");
                    break;

                //Selecting Payment Option, calls paymentSwitch Method
                case 4:
                    System.out.println("How would you like to pay?");
                    payOption = validator.getInt(scnr, "1: Cash\n2: Credit Card\n3: Check\n", 1, 3);
                    paymentSwitch(payOption, cart.mapPrice, cart.mapQuantity, scnr);
                    cont = false;
                    break;
                case 5:
                    System.out.println("Clearing cart");
                    cart.mapQuantity.clear();
                    cart.mapLineTotal.clear();
                    cart.mapPrice.clear();
                    cart.mapName.clear();
                    cart.mapCategory.clear();
                    cart.mapDescription.clear();
                    System.out.println("Cleared\nMake sure to view menu again please!");
                default:
                    break;
            }
        } // end While
    } // end Main


    /**
     * @param payOption
     * @param cartPayment
     * @param quantity
     * @param scnr
     */
    public static void paymentSwitch(int payOption, HashMap<Integer, String> cartPayment, HashMap<Integer, String> quantity, Scanner scnr) {
        //Method for choosing Payment option via Switch case
        switch (payOption) {

            //cash payment option
            case 1:
                Cash cash = new Cash();
                System.out.println("Amount Due:");
                double subtotal = cash.subtotal(cartPayment, quantity);
                System.out.printf("Subtotal: $" + "%.2f", subtotal);
                System.out.println();
                double grandTotal = cash.getgrandtotal(subtotal);
                System.out.printf("Grand Total: $" + "%.2f", grandTotal);
                System.out.println();
                double cashReceived = cash.getCashReceived(scnr);
                if (cashReceived < grandTotal) {
                    System.out.println("You don't have enough. There is no such thing as a free lunch!");
                    break;
                }
                double change = cash.getChangeGiven(cashReceived, grandTotal);
                System.out.printf("Cash Tendered: $" + "%.2f" + " ", cashReceived);
                System.out.printf("Change: $" + "%.2f" + " ", change);
                System.out.println("Thank you please come again soon!");
                break;

            //credit card payment option
            case 2:
                CreditCard cc = new CreditCard();
                System.out.println();
                cc.getCreditCardNum();
                cc.getcVV();
                cc.getExpDate();
                subtotal = cc.subtotal(cartPayment, quantity);
                System.out.printf("Subtotal: $" + "%.2f" + " ", subtotal);
                System.out.println();
                grandTotal = cc.getgrandtotal(subtotal);
                System.out.printf("Grand Total: $" + "%.2f" + " ", grandTotal);
                System.out.println();
                System.out.println("Credit Card Accepted: Thank you for your payment");
                break;

            //check payment option
            case 3:
                Check check = new Check();
                subtotal = check.subtotal(cartPayment, quantity);
                System.out.printf("Subtotal: $" + "%.2f" + " ", subtotal);
                System.out.println();
                grandTotal = check.getgrandtotal(subtotal);
                System.out.printf("Grand Total: $" + "%.2f" + " ", grandTotal);
                System.out.println();
                check.getCheckNum();
                System.out.println("Check Accepted: Thank you for your payment");
                break;
        }
    } // end paymentSwitch
} // end Main class
