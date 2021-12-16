package main.java.com.igeek.dao.impl;

import main.java.com.igeek.bean.Category;
import main.java.com.igeek.dao.iface.CategoryIface;
import main.java.com.igeek.dao.util.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryImpl implements CategoryIface {
    @Override
    public List<Category> getCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from category";
        return runner.query(sql,new BeanListHandler<>(Category.class));
    }
}
