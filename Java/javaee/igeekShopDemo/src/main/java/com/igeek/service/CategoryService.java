package main.java.com.igeek.service;

import main.java.com.igeek.bean.Category;
import main.java.com.igeek.dao.impl.CategoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    CategoryImpl categoryImpl = new CategoryImpl();
    // 获取所有分类
    public List<Category> getCategoryList(){
        try {
            return categoryImpl.getCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
