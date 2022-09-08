package pizzaDelivery;

import java.util.*;
import java.sql.DriverManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

class hereOrder implements OrderImpl {
    String name, size;
    int ch;
    Scanner sc = new Scanner(System.in);
    Pizza ph = new Pizza();
    Bill bill = new Bill();

    public void connectDB(String tableName, String name, String psize, int price) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                    "admin");
            if (connection == null) {
                System.out.println("Connection Not Established");
            }
            Statement statement = connection.createStatement();
            ResultSet num = statement.executeQuery("select count(name) from vegOrder");
            num.next();
            int count = num.getInt(1);

            String insertTable = "insert into " + tableName + "(sno,name ,psize,price)values('" + count + "','" + name
                    + "','"
                    + psize
                    + "','" + price + "')";

            String insertbill = "insert into billOrder(sno,bname ,bsize,bprice)values('" + count + "','" + name
                    + "','"
                    + psize
                    + "','" + price + "')";

            statement.executeUpdate(insertTable);
            statement.executeUpdate(insertbill);
            System.out.println("--------------------------------------------------");
            System.out.println("Order Details Saved !");
            System.out.println("--------------------------------------------------");

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    // List<Map<String, String>> database = new ArrayList<Map<String, String>>();

    public void takeVegOrder() {
        String tname = "vegOrder";
        Order od = new Order();
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> mapPrice = new HashMap<String, Integer>();
        System.out.println("Enter Name of pizza you want to order: ");
        name = sc.nextLine();
        System.out.println("Enter the size of Pizza: L->Large, M->Medium, S->Small");
        size = sc.next();

        if ((name.equals("Veg-Supreme")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(250);
        } else if ((name.equals("Veg-Supreme")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(200);
        } else if ((name.equals("Veg-Supreme")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(180);
        } else if ((name.equals("Supreme-Paneer")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(280);
        } else if ((name.equals("Supreme-Paneer")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(230);
        } else if ((name.equals("Supreme-Paneer")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(180);
        } else if ((name.equals("Veggie-Paneer")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(320);
        } else if ((name.equals("Veggie-Paneer")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(270);
        } else if ((name.equals("Veggie-Paneer")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(220);
        } else if ((name.equals("Capssicum-Paneer")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(325);
        } else if ((name.equals("Capssicum-Paneer")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(275);
        } else if ((name.equals("Capssicum-Paneer")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(225);
        } else if ((name.equals("Spicy-Paneer")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(350);
        } else if ((name.equals("Spicy-Paneer")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(275);
        } else if ((name.equals("Spicy-Paneer")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(250);
        } else if ((name.equals("Paneer-Makhni")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(380);
        } else if ((name.equals("Paneer-Makhni")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(330);
        } else if ((name.equals("Paneer-Makhni")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(280);
        } else if ((name.equals("Farmhouse-Paneer")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(480);
        } else if ((name.equals("Farmhouse-Paneer")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(430);
        } else if ((name.equals("Farmhouse-Paneer")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Small");
            ph.setPrice(380);
        }

        map.put("name", ph.getName());
        map.put("size", ph.getSize());

        mapPrice.put("price", ph.getPrice());

        connectDB(tname, map.get("name"), map.get("size"), mapPrice.get("price"));
        od.repeatOrder();
        // bill.billPart();
    }

    public void takeNonVegOrder() {
        String tname = "vegOrder";
        Order od = new Order();
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> mapPrice = new HashMap<String, Integer>();
        System.out.println("Enter Name of pizza you want to order: ");
        name = sc.next();
        System.out.println("Enter the size of Pizza: L->Large, M->Medium, S->Small");
        size = sc.next();
        if ((name.equals("Chicken-Supreme")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(350);
        } else if ((name.equals("Chicken-Supreme")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(300);
        } else if ((name.equals("Chicken-Supreme")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(250);
        } else if ((name.equals("Supreme-Crushed Chicken")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(380);
        } else if ((name.equals("Supreme-Crushed Chicken")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(330);
        } else if ((name.equals("Supreme-Crushed Chicken")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(280);
        } else if ((name.equals("Tandoori-Chicken")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(420);
        } else if ((name.equals("Tandoori-Chicken")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(370);
        } else if ((name.equals("Tandoori-Chicken")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(320);
        } else if ((name.equals("Barbeque-Chicken")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(425);
        } else if ((name.equals("Barbeque-Chicken")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(375);
        } else if ((name.equals("Barbeque-Chicken")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(325);
        } else if ((name.equals("Spicy-Chicken")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(450);
        } else if ((name.equals("Spicy-Chicken")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(400);
        } else if ((name.equals("Spicy-Chicken")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(350);
        } else if ((name.equals("Crushed-Chicken")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(480);
        } else if ((name.equals("Crushed-Chicken")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(430);
        } else if ((name.equals("Crushed-Chicken")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(380);
        } else if ((name.equals("Farmhouse-Chicken")) && (size.equals("L") || size.equals("l"))) {
            ph.setName(name);
            ph.setSize("Large");
            ph.setPrice(580);
        } else if ((name.equals("Farmhouse-Chicken")) && (size.equals("M") || size.equals("m"))) {
            ph.setName(name);
            ph.setSize("Medium");
            ph.setPrice(530);
        } else if ((name.equals("Farmhouse-Chicken")) && (size.equals("S") || size.equals("s"))) {
            ph.setName(name);
            ph.setSize("Samll");
            ph.setPrice(480);
        }

        map.put("name", ph.getName());
        map.put("size", ph.getSize());
        mapPrice.put("price", ph.getPrice());
        connectDB(tname, map.get("name"), map.get("size"), mapPrice.get("price"));
        od.repeatOrder();
        // bill.billPart();

    }

}