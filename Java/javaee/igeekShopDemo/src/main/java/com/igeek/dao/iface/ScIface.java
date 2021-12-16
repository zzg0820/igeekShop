package main.java.com.igeek.dao.iface;

import main.java.com.igeek.bean.ScWithItem;
import main.java.com.igeek.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface ScIface {
    // 根据用户Id获取当前用户购物车
    public ScWithItem getCartByUid(String uId) throws SQLException;

    // 根据商品id查询当前用户购物车中是否存在
    public ScWithItem findProById(int pId,String uId) throws SQLException;

    // 新建购物车
    public int addShoppingCart(User user) throws SQLException;

    // 添加到购物车
    public int addCartItem(ScWithItem sc) throws SQLException;

    // 更新数量
    public int updateNum(ScWithItem sc) throws SQLException;

    // 根据用户查找购物车列表
    public List<ScWithItem> getScList(User user) throws SQLException;

    // 根据商品id删除购物车数据
    public int deleteItemByPid(int pId, int sId) throws SQLException;

    // 清空购物车
    public int removeShoppingCart(int sId) throws SQLException;
    public int removeCartItem(int sId) throws SQLException;
}
