package pizzaDelivery;

import java.util.*;

public class App {

    public static void printWelcomeMessage() {
        System.out.println("\n**************************************************");
        System.out.println("|              Welcome To SATURN PIZZA           |");
        System.out.println("**************************************************");
        System.out.println("|          We Serve The World's Best Pizza       |");
        System.out.println("**************************************************");
    }

    public static void main(String[] args) throws Exception {

        printWelcomeMessage();
        User um = new User();
        Bill bill = new Bill();
        um.userInfo();
        um.dbInsert();
        um.dbUpdate();
        giveOrder();
        bill.paymentMethod();
        bill.feedBack();
        bill.billPart();

    }

    static void giveOrder() {

        int ch;
        Order od = new Order();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter 1 For Veg Pizzas OR Enter 2 for Non-Veg Pizza");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                od.vegOrder();
                break;

            case 2:
                od.nonVegOrder();
                break;

        }
    }

}