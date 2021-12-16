package main.java.com.igeek.dao.iface;

import main.java.com.igeek.bean.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryIface {
    // 获取分类列表
    public List<Category> getCategory() throws SQLException;
}
