package main.java.com.igeek.bean;

public class ScWithItem {
    private int sid;
    private String uid;
    private int state;
    private int pId;
    private String pImage;
    private String pName;
    private int num;
    private double shop_price;
    private double subPrice;

    @Override
    public String toString() {
        return "ScWithItem{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", state=" + state +
                ", pId=" + pId +
                ", pImage='" + pImage + '\'' +
                ", pName='" + pName + '\'' +
                ", num=" + num +
                ", shop_price=" + shop_price +
                '}';
    }

    public ScWithItem() {
    }

    public ScWithItem(int sid, String uid, int state, int pId, String pImage, String pName, int num, double shop_price) {
        this.sid = sid;
        this.uid = uid;
        this.state = state;
        this.pId = pId;
        this.pImage = pImage;
        this.pName = pName;
        this.num = num;
        this.shop_price = shop_price;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
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

    public double getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(double subPrice) {
        this.subPrice = subPrice;
    }
}
