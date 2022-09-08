package pizzaDelivery;

import java.util.HashMap;

public class Pizza {
    private String pizzaName;
    private String size;
    private String topings;
    private int price;
    private String feedBack;
    private String paymentMethod;

    public void setName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getName() {
        return pizzaName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTopings() {
        return topings;
    }

    public void setTopings(String topings) {
        this.topings = topings;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setfeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getfeedBack() {
        return feedBack;
    }

    public void setpaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getpaymentMethod() {
        return paymentMethod;
    }
}
