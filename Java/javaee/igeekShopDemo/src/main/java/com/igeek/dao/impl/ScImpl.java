package main.java.com.igeek.dao.impl;

import main.java.com.igeek.bean.ScWithItem;
import main.java.com.igeek.bean.User;
import main.java.com.igeek.dao.iface.ScIface;
import main.java.com.igeek.dao.util.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ScImpl implements ScIface {
    @Override
    public ScWithItem getCartByUid(String uId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from shoppingCart where uid = ?";
        return runner.query(sql,new BeanHandler<>(ScWithItem.class),uId);
    }

    @Override
    public ScWithItem findProById(int pId, String uId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select s.*,c.pid,c.pImage,c.pName,c.num,c.shop_price from shoppingCart s join cartItem c on" +
                " s.sid = c.sid where uid = ? and pid = ?";
        return runner.query(sql,new BeanHandler<>(ScWithItem.class),uId,pId);
    }

    @Override
    public int addShoppingCart(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "insert into shoppingCart values(0,?,0)";
        return runner.update(sql,user.getUid());
    }

    @Override
    public int addCartItem(ScWithItem sc) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "insert into cartItem values(0,?,?,?,?,?,?)";
        return runner.update(sql,sc.getSid(),sc.getpId(),sc.getpImage(),sc.getpName(),sc.getNum(),sc.getShop_price());
    }

    @Override
    public int updateNum(ScWithItem sc) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "update cartItem set num = ? where sid = ? and pid = ?";
        return runner.update(sql,sc.getNum(),sc.getSid(),sc.getpId());
    }

    @Override
    public List<ScWithItem> getScList(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select s.*,c.pid,c.pImage,c.pName,c.num,c.shop_price from shoppingCart s join cartItem c on " +
                "s.sid = c.sid where uid = ? ";
        return runner.query(sql,new BeanListHandler<>(ScWithItem.class),user.getUid());
    }

    @Override
    public int deleteItemByPid(int pId, int sId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "delete from cartItem where sid = ? and pid = ?";
        return runner.update(sql,sId,pId);
    }

    @Override
    public int removeShoppingCart(int sId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "delete from shoppingCart where sid = ?";
        return runner.update(sql,sId);
    }

    @Override
    public int removeCartItem(int sId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "delete from cartItem where sid = ?";
        return runner.update(sql,sId);
    }
}
