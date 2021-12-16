package main.java.com.igeek.service;

import main.java.com.igeek.bean.Product;
import main.java.com.igeek.dao.impl.ProductImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductImpl productImpl = new ProductImpl();
    // 获取最热商品
    public List<Product> getHotPro(){
        List<Product> hotPro = new ArrayList<>();
        try {
            hotPro = productImpl.getHotPro();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotPro;
    }

    // 获取最新商品
    public List<Product> getNewPro(){
        List<Product> newPro = new ArrayList<>();
        try {
            newPro  = productImpl.getNewPro();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newPro;
    }

    // 根据id查找商品
    public Product getProById(int pId){
        Product pro = null;
        try {
            pro = productImpl.getProById(pId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pro;
    }

    // 根据分类id查找商品
    public List<Product> getProListByCid(String cid){
        List<Product> productList = new ArrayList<>();
        try {
            productList  = productImpl.getProListByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    // 根据分类id查找商品
    public int getProNumByCid(String cid){
        try {
            return  (Integer) productImpl.getProNumByCid(cid).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<Product> getProListByPage(String cId, int currentPage, int rows){
        List<Product> proListByPage = new ArrayList<>();
        try {
            proListByPage = productImpl.getProListByPage(cId, currentPage, rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proListByPage;
    }
}
