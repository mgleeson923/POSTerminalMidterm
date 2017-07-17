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
 * <p>
 * JavaDOC located at JavaDocPostTerminalMidterm/index.html in Repo
 */

public class POSMain {

    public static void main(String[] args) {
        System.out.println("Welcome to M3V! My Name is Jarvis, how may I serve you? ");
        System.out.println("POS Terminal Console");

        //Variables for Cart, Validation, and Payment Choices
        int orderNumber;
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
            caseNumber = validator.getInt(scnr, "1: View Menu & Add Item to Order\n2: View Current Order\n3: Checkout\n4: Clear Order\n", 1, 4);
            switch (caseNumber) {

                //creates menu
                case 1:
                    menu.createMenu(0);
                    System.out.println("---------------------------");
                    String repeat = "y";
                    while (repeat.equalsIgnoreCase("y")) {
                        orderNumber = validator.getInt(scnr, "Please enter the number of the item you wish to add to order: ");
                        while (orderNumber == 10) {
                            orderNumber = validator.getInt(scnr, "Sorry, our Ice Cream Machine is currently out of order. Please select another item: ");
                        }
                        quantity = validator.getInt(scnr, "How many would you like?: ");
                        while (quantity == 0) {
                            System.out.println("\nPlease add a quantity of 1 or more to your order!");
                            quantity = validator.getInt(scnr, "How many would you like? ");
                        }
                        String menuItemtoAdd = menu.mapName.get(orderNumber);
                        String menuPricetoAdd = menu.mapPrice.get(orderNumber);
                        cart.mapName.put(orderNumber, menuItemtoAdd);
                        cart.mapPrice.put(orderNumber, menuPricetoAdd);
                        cart.mapQuantity.put(orderNumber, Integer.toString(quantity));
                        System.out.println();
                        repeat = validator.getString(scnr, "Would you like to order another item? Y/N: ");
                    }
                    System.out.println("---------------------------");
                    break;

                //Cart viewer with Quantity, Item, Price, and Line Total and Grand Total
                case 2:
                    System.out.println("Your Current Order is: \n");
                    double cartTotal = 0;
                    for (int Key : cart.mapName.keySet()) {
                        cart.mapLineTotal.put(Key, Double.parseDouble(cart.mapPrice.get(Key)) * Double.parseDouble(cart.mapQuantity.get(Key)));
                        System.out.printf(cart.mapName.get(Key) + " - Quantity: " + cart.mapQuantity.get(Key));
                        System.out.println();
                        System.out.printf("Item Price: $" + cart.mapPrice.get(Key) + "\nLine Total: $" + "%.2f", cart.mapLineTotal.get(Key));
                        cartTotal += cart.mapLineTotal.get(Key);
                        System.out.println();
                        System.out.println();
                    }
                    System.out.printf("Total: $" + "%.2f", cartTotal);
                    System.out.println();
                    System.out.println("---------------------------");
                    break;

                //Selecting Payment Option, calls paymentSwitch Method
                case 3:
                    System.out.println("How would you like to pay?");
                    payOption = validator.getInt(scnr, "1: Cash\n2: Credit Card\n3: Check\n", 1, 3);
                    paymentSwitch(payOption, cart.mapPrice, cart.mapQuantity, scnr);
                    cont = false;
                    break;
                case 4:
                    System.out.println("Clearing Order");
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
                while (cashReceived < grandTotal) {
                    System.out.println("This is not enough money. There's no such thing as a free lunch!");
                    cashReceived = cash.getCashReceived(scnr);
                }
                double change = cash.getChangeGiven(cashReceived, grandTotal);
                System.out.printf("Cash Tendered: $" + "%.2f" + " ", cashReceived);
                System.out.println();
                System.out.printf("Change: $" + "%.2f" + " ", change);
                System.out.println();
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
