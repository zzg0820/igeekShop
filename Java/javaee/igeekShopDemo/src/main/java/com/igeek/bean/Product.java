package main.java.com.igeek.bean;

public class Product {
    private int pId;
    private String pName;
    private double market_price;
    private double shop_price;
    private String pImage;
    private String pDate;
    private int isHot;
    private String pDesc;
    private int pFlag;
    private int cId;
    private String cName;

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", market_price=" + market_price +
                ", shop_price=" + shop_price +
                ", pImage='" + pImage + '\'' +
                ", pDate='" + pDate + '\'' +
                ", isHot=" + isHot +
                ", pDesc='" + pDesc + '\'' +
                ", pFlag=" + pFlag +
                ", cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(int pId, String pName, double market_price, double shop_price, String pImage, String pDate, int isHot, String pDesc, int pFlag, int cId, String cName) {
        this.pId = pId;
        this.pName = pName;
        this.market_price = market_price;
        this.shop_price = shop_price;
        this.pImage = pImage;
        this.pDate = pDate;
        this.isHot = isHot;
        this.pDesc = pDesc;
        this.pFlag = pFlag;
        this.cId = cId;
        this.cName = cName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public int getpFlag() {
        return pFlag;
    }

    public void setpFlag(int pFlag) {
        this.pFlag = pFlag;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
