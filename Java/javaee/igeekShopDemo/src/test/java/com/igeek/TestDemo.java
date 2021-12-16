package test.java.com.igeek;

import main.java.com.igeek.bean.Product;
import main.java.com.igeek.dao.impl.ProductImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class TestDemo {
    @Test
    public void test01(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        System.out.println(uuid);
    }
    @Test
    public void test02()
    {
        ProductImpl product = new ProductImpl();
        List<Product> hotPro = null;
        try {
            hotPro = product.getHotPro();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(hotPro);
    }
}
