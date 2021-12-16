package main.java.com.igeek.bean;

import java.util.List;

public class ShoppingCart {
    private List<ScWithItem> items;
    private double allPrice;

    public List<ScWithItem> getItems() {
        return items;
    }

    public void setItems(List<ScWithItem> items) {
        this.items = items;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }
}
