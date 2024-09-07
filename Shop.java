package ShopSystem;

import java.util.Scanner;

public class Shop {
    private String ID;
    private String ShopName;
    private String Address;
    private String Date;
    private String Size;
    private double InPrice;
    private double SalePrice;
    private int Numbers;

    //构造函数
    public Shop(String id, String shopName, String address, String date,
                String size, double inPrice, double salePrice, int numbers) {
        ID = id;
        ShopName = shopName;
        Address = address;
        Date = date;
        Size = size;
        InPrice = inPrice;
        SalePrice = salePrice;
        Numbers = numbers;
    }

    public Shop() {
    }

    //添加商品信息(finish)
    public void addShopInfom() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入商品的编号：");
        String id = sc.next();
        System.out.print("请输入商品的名称：");
        String shopname = sc.next();
        System.out.print("请输入生产厂家：");
        String address = sc.next();
        System.out.print("请输入生产日期：");
        String date = sc.next();
        System.out.print("请输入型号：");
        String size = sc.next();
        System.out.print("请输入进货价：");
        double inprice = sc.nextDouble();
        System.out.print("请输入零售价格：");
        double saleprice = sc.nextDouble();
        System.out.print("请输入数量：");
        int numbers = sc.nextInt();
        ID = id;
        ShopName = shopname;
        Address = address;
        Date = date;
        Size = size;
        InPrice = inprice;
        SalePrice = saleprice;
        Numbers = numbers;
        System.out.println("添加成功！");
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public double getInPrice() {
        return InPrice;
    }

    public void setInPrice(double inPrice) {
        InPrice = inPrice;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }

    public int getNumbers() {
        return Numbers;
    }

    public void setNumbers(int numbers) {
        Numbers = numbers;
    }
}

