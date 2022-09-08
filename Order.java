package pizzaDelivery;

import java.util.*;

class Order extends hereOrder {
    OrderImpl od = new hereOrder();

    public void vegOrder() {
        System.out.println("\n**************************************************");
        System.out.println("|                Menu For Veg Order              |");
        System.out.println("**************************************************");
        System.out.println("|  1. Veg-Supreme Pizza                Rs 150(s) |");
        System.out.println("|  2. Supreme-Paneer Pizza             Rs 180(s) |");
        System.out.println("|  3. Veggie-Paneer Pizza              Rs 220(s) |");
        System.out.println("|  4. Capssicum-Paneer Pizza           Rs 225(s) |");
        System.out.println("|  5. Spicy-Paneer Pizza               Rs 250(s) |");
        System.out.println("|  6. Paneer-Makhni Pizza              Rs 280(s) |");
        System.out.println("|  7. Farmhouse-Paneer Pizza     Rs 380(s) |");
        System.out.println(
                " \n* Price is displayed for Small(s) Size and increases\n Rs 50 for Medium(m) size and Rs 100 for Large(l) size *");
        System.out.println("**************************************************\n");
        od.takeVegOrder();
    }

    public void nonVegOrder() {
        System.out.println("\n**************************************************");
        System.out.println("|              Menu For Non-Veg Order            |");
        System.out.println("**************************************************");
        System.out.println("|  1. Chicken-Supreme Pizza            Rs 250(s) |");
        System.out.println("|  2. Supreme-Crushed Chicken Pizza    Rs 280(s) |");
        System.out.println("|  3. Tandoori-Chicken Pizza           Rs 320(s) |");
        System.out.println("|  4. Barbeque-Chicken Pizza           Rs 325(s) |");
        System.out.println("|  5. Spicy-Chicken Pizza              Rs 350(s) |");
        System.out.println("|  6. Crushed-Chicken Pizza            Rs 380(s) |");
        System.out.println("|  7. Farmhouse-Chicken Pizza          Rs 480(s) |");
        System.out.println(
                " \n* Price is displayed for Small(s) Size and increases\n Rs 50 for Medium(m) size and Rs 100 for Large(l) size *");
        System.out.println("**************************************************\n");
        od.takeNonVegOrder();
    }

    public void repeatOrder() {
        System.out.println("\n**************************************************");
        System.out.println(
                "Do You Want To Order More! \nPress 1 for YES & Veg-Order  \nPress 2 for YES & NonVeg-Order \nPress 3 for NO & Continue Billing");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                vegOrder();
                break;

            case 2:
                nonVegOrder();
                break;

            case 3:
                break;
        }

    }

}
