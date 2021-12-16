package main.java.com.igeek.service;

import main.java.com.igeek.bean.Product;
import main.java.com.igeek.bean.ScWithItem;
import main.java.com.igeek.bean.ShoppingCart;
import main.java.com.igeek.bean.User;
import main.java.com.igeek.dao.impl.ProductImpl;
import main.java.com.igeek.dao.impl.ScImpl;
import main.java.com.igeek.dao.impl.UserImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScService {
    ScImpl scImpl = new ScImpl();
    UserImpl userImpl = new UserImpl();
    ProductImpl productImpl = new ProductImpl();
    // 根据用户Id查询当前用户是否有购物车
    public Boolean findCartByUid(String uId){
        ScWithItem sc = null;
        try {
            sc = scImpl.getCartByUid(uId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sc == null;
    }
    // 根据用户Id获取当前用户购物车
    public ScWithItem getCartByUid(String uId){
        ScWithItem sc = null;
        try {
            sc = scImpl.getCartByUid(uId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sc;
    }

    // 根据商品id查询当前用户购物车中是否存在
    public ScWithItem findProById(int pId, String uId){
        ScWithItem sc = null;
        try {
            sc = scImpl.findProById(pId, uId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sc;
    }

    // 根据用户查询购物车列表
    public ShoppingCart getScList(User user){
        ShoppingCart shoppingCart = new ShoppingCart();
        List<ScWithItem> scList = new ArrayList<>();
        try {
            scList = scImpl.getScList(user);
            shoppingCart.setItems(scList);
            for (ScWithItem sc : scList){
                sc.setSubPrice(sc.getShop_price()*sc.getNum());
                shoppingCart.setAllPrice(shoppingCart.getAllPrice()+sc.getSubPrice());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }

    // 新建购物车
    public int addShoppingCart(User user){
        int newCart = 0;
        try {
            newCart = scImpl.addShoppingCart(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCart;
    }

    // 添加到购物车
    public boolean addCartItem(User userByName,int num,Product proById) throws SQLException {
        // 构建对象
        ScWithItem cartByUid1 = scImpl.getCartByUid(userByName.getUid());
        System.out.println(cartByUid1);
        // 设置参数
        cartByUid1.setpId(proById.getpId());
        cartByUid1.setpName(proById.getpName());
        cartByUid1.setNum(num);
        cartByUid1.setpImage(proById.getpImage());
        cartByUid1.setShop_price(proById.getShop_price());
        // 添加物品
        int i1 = scImpl.addCartItem(cartByUid1);
        if (i1 == 1){
            System.out.println("添加购物车成功");
            return true;
        }else {
            System.out.println("添加购物车失败");
            return false;
        }
    }

    // 添加到购物车
    public boolean addShopCart(int pid, int num, User userByName){
        System.out.println(pid+".."+num+".."+userByName.toString());
        try {
            // 根据pid获取商品详情
            Product proById = productImpl.getProById(pid);
            System.out.println(proById.toString());

            ScWithItem cartByUid = scImpl.getCartByUid(userByName.getUid());
            if (cartByUid == null){
                // 如果不存在购物车则新建购物车
                int i = scImpl.addShoppingCart(userByName);
                if (i == 1){
                    System.out.println("新建购物车成功");
                    boolean b = addCartItem(userByName, num, proById);
                    if (b){
                        System.out.println("添加购物车成功");
                        return true;
                    }else {
                        System.out.println("添加购物车失败");
                        return false;
                    }
                }else {
                    System.out.println("新建购物车失败");
                    return false;
                }
            }else {
                // 根据商品id查找是否在购物车中
                ScWithItem proById1 = scImpl.findProById(pid, userByName.getUid());
                if (proById1 == null){
                    // 构建对象
                    ScWithItem cartByUid1 = scImpl.getCartByUid(userByName.getUid());
                    System.out.println(cartByUid1);
                    // 设置参数
                    cartByUid1.setpId(proById.getpId());
                    cartByUid1.setpName(proById.getpName());
                    cartByUid1.setNum(num);
                    cartByUid1.setpImage(proById.getpImage());
                    cartByUid1.setShop_price(proById.getShop_price());
                    System.out.println(cartByUid1);
                    // 添加物品
                    int i1 = scImpl.addCartItem(cartByUid1);
                    if (i1 == 1){
                        System.out.println("添加购物车成功");
                        return true;
                    }else {
                        System.out.println("添加购物车失败");
                        return false;
                    }
                }else {
                    ScWithItem proById2 = scImpl.findProById(pid, userByName.getUid());
                    // 更新数量
                    int num1 = proById2.getNum();
                    proById2.setNum(num1+num);
                    int i = scImpl.updateNum(proById2);
                    if (i == 1){
                        System.out.println("更新成功");
                        return true;
                    }else{
                        System.out.println("更新失败");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 删除购物车数据
    public boolean deleteCartItem(int pId, User loginUser) {
        try {
            ScWithItem cartByUid = scImpl.getCartByUid(loginUser.getUid());
            int i = scImpl.deleteItemByPid(pId, cartByUid.getSid());
            if (i==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 清空购物车
    public boolean removeCart(User loginUser){
        try {
            ScWithItem cartByUid = scImpl.getCartByUid(loginUser.getUid());
            int i = scImpl.removeCartItem(cartByUid.getSid());
            int i1 = scImpl.removeShoppingCart(cartByUid.getSid());
            if (i == 1 && i1 ==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
