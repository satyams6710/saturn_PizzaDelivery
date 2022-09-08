package pizzaDelivery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bill {

    Pizza ph = new Pizza();

    public void billPart() {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                    "admin");
            if (connection == null) {
                System.out.println("Connection Not Established");
            }
            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery("select * from billOrder");

            while (result.next()) {
                mainBill();
            }

            result = statement.executeQuery("delete from billOrder");
            result.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void mainBill() {

        int dp = 0;
        File file = new File("Bill.txt");
        PrintStream stream;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                    "admin");
            if (connection == null) {
                System.out.println("Connection Not Established");
            }

            Statement statement = connection.createStatement();
            ResultSet result = statement
                    .executeQuery("select * from billOrder");
            stream = new PrintStream(file);
            System.setOut(stream);

            System.out.println("\n************************************************************");
            System.out.println("|                Thankyou for Ordering with Us!            |");
            System.out.println("************************************************************");
            System.out.println("|               We Serve The World's Best Pizza            |");
            System.out.println("************************************************************\n");
            System.out.println("                                                            ");
            System.out.println("                         ORDER SUMMARY                      ");
            System.out.println("------------------------------------------------------------");
            System.out.println("|                                                          |");
            System.out.println("|   Pizza_Name               Size                   Price  |");
            System.out.println("|                                                          |");
            while (result.next()) {
                String dbname = result.getString("bname");
                String dbsize = result.getString("bsize");
                int dbprice = result.getInt("bprice");
                System.out
                        .println("|" + dbname + "              " + dbsize + "                    " + dbprice);
                dp = dp + dbprice;
            }
            System.out.println("|                                                          |");
            System.out.println("------------------------------------------------------------");
            System.out.println("|                                 Total Payable Amount:" + dp);

            System.out.println("|                                                          |");
            System.out
                    .println("|                               Chossen Payment Method " + ph.getpaymentMethod() + " |");
            System.out.println("------------------------------------------------------------");
            System.out.println("|                                                          |");
            System.out.println("|           ThankYou For Giving " + ph.getfeedBack() + " Feedback         |");
            System.out.println("|                                                          |");
            System.out.println("************************************************************");

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    void feedBack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n************************************************************");
        System.out.println("|          Your FeedBack Is very Important To Us!          |");
        System.out.println("************************************************************");
        System.out.println("Enter 1 for Average\nEnter 2 for Good\nEnter 3 for Excellent");
        int ch;

        ch = sc.nextInt();

        switch (ch) {
            case 1:
                ph.setfeedBack("Average");
                break;
            case 2:
                ph.setfeedBack("Good");
                break;
            case 3:
                ph.setfeedBack("Excellent");
                break;
        }

    }

    void paymentMethod() {
        System.out.println("************************************************************");
        System.out.println("Choose You Payment Option ");
        System.out.println("1. Cash Method\n2. Debit/Credit Card\n3. Upi Method");
        int dh;
        Scanner sc = new Scanner(System.in);
        dh = sc.nextInt();
        switch (dh) {
            case 1:
                ph.setpaymentMethod("Cash");
                break;
            case 2:
                ph.setpaymentMethod("Card");
                break;
            case 3:
                ph.setpaymentMethod("UPI");
                break;
        }
        System.out.println("************************************************************");
    }
}