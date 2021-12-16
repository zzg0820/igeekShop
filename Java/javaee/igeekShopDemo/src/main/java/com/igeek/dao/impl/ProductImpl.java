package main.java.com.igeek.dao.impl;

import main.java.com.igeek.bean.Product;
import main.java.com.igeek.dao.iface.ProductIface;
import main.java.com.igeek.dao.util.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductImpl implements ProductIface {
    @Override
    public List<Product> getHotPro() throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from product where is_hot = 1 limit 9";
        return runner.query(sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> getNewPro() throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from product order by pdate desc limit 9";
        return runner.query(sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public Product getProById(int pId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select p.*, c.cname from product p join category c on p.cId = c.cId  where pId = ?";
        return runner.query(sql,new BeanHandler<>(Product.class),pId);
    }

    @Override
    public List<Product> getProListByCid(String cId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from product where cId = ?";
        return runner.query(sql,new BeanListHandler<>(Product.class),cId);
    }

    @Override
    public Long getProNumByCid(String cId) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select count(*) from product where cId = ?";
        return runner.query(sql,new ScalarHandler<>(),cId);
    }

    @Override
    public List<Product> getProListByPage(String cId, int currentPage, int rows) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from product where cId = ? limit ?,?";
        return runner.query(sql,new BeanListHandler<>(Product.class),cId,(currentPage-1)*rows,rows);
    }
}
