package ShopSystem;

import java.util.*;

public class ShopCart {
    private Map<Shop, Integer> shopcart = new HashMap<>();
    private String Time;

    //构造函数
    public ShopCart() {
    }

    public Map<Shop, Integer> getShopcart() {
        return shopcart;
    }

    public void setShopcart(Shop shop, int quantity) {
        shopcart.put(shop, quantity);
    }

    public void removeShopcart(Shop shop) {
        shopcart.remove(shop);
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}

