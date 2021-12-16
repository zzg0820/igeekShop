package main.java.com.igeek.bean;

public class CartItem {
    private int cid;
    private int sid;
    private int pid;
    private String pName;
    private int num;
    private double shop_price;

    public CartItem() {
    }

    public CartItem(int cid, int sid, int pid, String pName, int num, double shop_price) {
        this.cid = cid;
        this.sid = sid;
        this.pid = pid;
        this.pName = pName;
        this.num = num;
        this.shop_price = shop_price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }
}
