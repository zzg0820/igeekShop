package main.java.com.igeek.dao.iface;

import main.java.com.igeek.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductIface {

    // 获取热门商品
    public List<Product> getHotPro() throws SQLException;

    // 获取最新商品
    public List<Product> getNewPro() throws SQLException;

    // 根据id查找商品
    public Product getProById(int pId) throws SQLException;

    // 根据分类id查找商品
    public List<Product> getProListByCid(String cId) throws SQLException;

    // 根据分类id查找商品数量
    public Long getProNumByCid(String cId) throws SQLException;

    // 根据分页查找商品
    public List<Product> getProListByPage(String cId, int currentPage, int rows) throws SQLException;
}
