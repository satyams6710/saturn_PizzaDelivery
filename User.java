package pizzaDelivery;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.DriverManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class User {
    String name, email;
    Long phNo;
    Scanner sc = new Scanner(System.in);

    void userInfo() {
        int flag1;
        boolean flag = false;
        do {
            Pattern pat1 = Pattern.compile("[(a-z,A-Z)]");

            System.out.println("Please Enter your name: ");
            name = sc.next();
            Matcher mat1 = pat1.matcher(name);
            if (mat1.find()) {
                flag = true;
            } else {
                System.out.println("\nPlease Enter Valid name!!!");
            }
        } while (!flag);
        System.out.println("--------------------------------------------------");
        do {
            try {
                long length = 0;
                while (length != 10) {

                    System.out.println("Please Enter your Mob. No. : ");
                    phNo = sc.nextLong();
                    length = (long) (Math.log10(phNo) + 1);
                    if (length != 10) {
                        System.out.println("\n *Invalid phone number!* ");
                    }
                }
                flag1 = 1;
            } catch (InputMismatchException ie) {
                System.out.println("\n*Please enter digits only*");
                sc.nextLine();
                flag1 = 0;
                continue;
            }
        } while (flag1 == 0);
        System.out.println("--------------------------------------------------");
        System.out.println("Please Enter your Email : ");
        email = sc.next();
        System.out.println("--------------------------------------------------");
    }

    void dbInsert() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                    "admin");
            if (connection == null) {
                System.out.println("Connection Not Established");
            }
            // String createTable = "create table userTable(name varchar(25),phone
            // number(10))";
            Statement statement = connection.createStatement();
            ResultSet num = statement.executeQuery("select count(name) from userTable");
            num.next();
            int count = num.getInt(1);
            String insertTable = "insert into userTable(sno, name ,phone,email)values('" + count + "','" + name + "','"
                    + phNo
                    + "','" + email + "')";

            statement.executeUpdate(insertTable);
            System.out.println("--------------------------------------------------");
            System.out.println("Saved Details !");
            System.out.println("--------------------------------------------------");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void dbUpdate() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                    "admin");
            if (connection == null) {
                System.out.println("Connection Not Established");
            }
            Statement statement = connection.createStatement();
            ResultSet num = statement.executeQuery("select count(name) from userTable");
            num.next();
            int count = num.getInt(1);
            int c = count - 1;
            ResultSet result = statement
                    .executeQuery("select * from userTable where sno=" + c + "");
            if (result.next() != false) {
                String cname = result.getString("name");
                String cemail = result.getString("email");
                Long cphone = result.getLong("phone");
                displayInfo(cname, cemail, cphone);
            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void displayInfo(String bdname, String dbemail, Long dbphone) {
        int num;
        System.out.println("\n**************************************************");
        System.out.println("| Hey " + bdname + ", We Welcome You Here");
        System.out.println("--------------------------------------------------");
        System.out.println("| Please Verify Your Details                     |");
        System.out.println("--------------------------------------------------");
        System.out.println("| Name: " + bdname);
        System.out.println("| Mobile No. : " + dbphone);
        System.out.println("| Email: " + dbemail);
        System.out.println("**************************************************");
        System.out.println("\nEnter 1 to Continue OR Enter 2 to Edit");
        num = sc.nextInt();
        switch (num) {

            case 1:
                break;

            case 2:
                userInfo();
                dbInsert();
                dbUpdate();
                break;
        }
    }
}
