package pizzaDelivery;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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
    int phNo;
    Scanner sc = new Scanner(System.in);

    void userInfo() {
        System.out.println("Please Enter your name: ");
        name = sc.next();
        System.out.println("--------------------------------------------------");
        System.out.println("Please Enter your Mob. No. : ");
        phNo = sc.nextInt();
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
                int cphone = result.getInt("phone");
                displayInfo(cname, cemail, cphone);
            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void displayInfo(String bdname, String dbemail, int dbphone) {
        int num;
        System.out.println("\n**************************************************");
        System.out.println("| Hey " + bdname + ", We Welcome You Here");
        System.out.println("--------------------------------------------------");
        System.out.println("| Please Verify Your Details                     |");
        System.out.println("--------------------------------------------------");
        System.out.println("| Name: " + bdname);
        System.out.println("| Mobile No. : " + dbemail);
        System.out.println("| Email: " + dbphone);
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
