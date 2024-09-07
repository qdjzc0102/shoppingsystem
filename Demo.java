package ShopSystem;

import java.util.*;

public class Demo {
    List<Shop> shop1 = new ArrayList<Shop>();
    List<User> user1 = new ArrayList<User>();
    Scanner sc = new Scanner(System.in);

    //构造函数
    public Demo() {
    }

    //填入客户信息(finish)
    public void addUser(User user) {
        user1.add(user);
    }

    //删除客户信息(finish)
    public void DeleteUser() {
        int flag = 0;
        System.out.println("请输入客户用户名：");
        String account = sc.next();
        for (int i = 0; i < user1.size(); i++) {
            if (user1.get(i).getAccount().equals(account)) {
                flag = 1;
                System.out.println("   确认删除？");
                System.out.println("1、是     2、否");
                int choice = sc.nextInt();
                if (choice == 1) {
                    user1.remove(user1.get(i));
                }
            }
        }
        if (flag == 0) {
            System.out.println("未找到对应用户");
        }
    }

    //查询客户信息(finish)
    public void FindUserInform() {
        int flag = 0;
        System.out.println("请输入客户的用户名：");
        String account = sc.next();
        for (int i = 0; i < user1.size(); i++) {
            if (user1.get(i).getAccount().equals(account)) {
                flag = 1;
                System.out.println("用户名：" + user1.get(i).getAccount() + "  用户注册时间" + user1.get(i).getTime() + "  用户邮箱" + user1.get(i).getMail());
            }
        }
        if (flag == 0) {
            System.out.println("未查询到对应客户。");
        }
    }

    //重置客户密码(finish)
    public void resetPassword(String account) {
        int flag = 0;
        for (int i = 0; i < user1.size(); i++) {
            if (user1.get(i).getAccount().equals(account)) {
                flag = 1;
                user1.get(i).setPassword("123456");
                System.out.println("重置成功！");
            }
        }
        if (flag == 0) {
            System.out.println("未找到对应客户");
        }
    }

    //填入商品信息(finish)
    public void addShop(Shop shop) {
        shop1.add(shop);
    }

    //遍历商品的信息(finish)
    public void Iter() {
        Iterator<Shop> iterator = shop1.iterator();
        while (iterator.hasNext()) {
            Shop shop = iterator.next();
            System.out.println("商品编号：" + shop.getID() + "  商品名称：" + shop.getShopName() + "  生产厂家：" +
                    shop.getAddress() + "  生产日期：" + shop.getDate() + "  型号：" + shop.getSize() + "  进货价：" +
                    shop.getInPrice() + "  零售价格：" + shop.getSalePrice() + "  数量：" + shop.getNumbers());
        }
    }

    //修改商品的信息(finish)
    public void ChangeInform() {
        boolean flag = false;
        System.out.println("请选择你要修改的商品的编号：");
        String id = sc.nextLine();
        for (int i = 0; i < shop1.size(); i++) {
            if (shop1.get(i).getID().equals(id)) {
                System.out.println("请选择您要修改的信息：");
                System.out.println("1、商品编号");
                System.out.println("2、商品名称");
                System.out.println("3、生产厂家");
                System.out.println("4、生产日期");
                System.out.println("5、型号");
                System.out.println("6、进货价");
                System.out.println("7、零售价格");
                System.out.println("8、数量");
                int choice = sc.nextInt();
                System.out.println("请输入您想修改的内容：");
                String inform = sc.next();
                if (choice == 1) shop1.get(i).setID(inform);
                else if (choice == 2) shop1.get(i).setShopName(inform);
                else if (choice == 3) shop1.get(i).setAddress(inform);
                else if (choice == 4) shop1.get(i).setDate(inform);
                else if (choice == 5) shop1.get(i).setSize(inform);
                else if (choice == 6) shop1.get(i).setInPrice(Double.parseDouble(inform));
                else if (choice == 7) shop1.get(i).setSalePrice(Double.parseDouble(inform));
                else if (choice == 8) shop1.get(i).setNumbers(Integer.parseInt(inform));
                System.out.println("修改成功！");
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("未找到该商品");
        }
    }

    //删除商品的信息(finish)
    public void DeleteInform() {
        System.out.println("请输入要删除的商品编号或名称：");
        boolean bool = false;
        String inform = sc.nextLine();
        for (int i = 0; i < shop1.size(); i++) {
            if ((inform.equals(shop1.get(i).getID())) || (inform.equals(shop1.get(i).getShopName()))) {
                shop1.remove(i);
                bool = true;
                System.out.println("删除成功！");
                break;
            }
        }
        if (bool == false) System.out.println("未查询到对应商品，删除失败！");
    }

    //查询商品的信息(finish)
    public void FindInform(int n) {
        boolean bool = false;
        if (n == 1) {
            System.out.println("请输入商品名称、生产厂家或零售价格");
            String inform = sc.nextLine();
            for (int i = 0; i < shop1.size(); i++) {
                if ((inform.equals(shop1.get(i).getShopName())) || (inform.equals(shop1.get(i).getAddress())) || (Integer.parseInt(inform) == shop1.get(i).getSalePrice())) {
                    System.out.println("查询成功！");
                    System.out.println("商品编号：" + shop1.get(i).getID() + "  商品名称：" + shop1.get(i).getShopName()
                            + "  生产厂家：" + shop1.get(i).getAddress() + "  生产日期：" + shop1.get(i).getDate() +
                            "  型号：" + shop1.get(i).getSize() + "  进货价：" + shop1.get(i).getInPrice() + "  零售价格："
                            + shop1.get(i).getSalePrice() + "  数量：" + shop1.get(i).getNumbers());
                    bool = true;
                }
            }
            if (bool == false) {
                System.out.println("未查询到对应商品，查询失败！");
            }
        }
        if (n == 2) {
            System.out.println("请输入商品名称或生产厂家：");
            String inform = sc.next();
            System.out.println("-请选择你想查询的范围-");
            System.out.println("1、最高价 | 2、最低价");
            int choice = sc.nextInt();
            System.out.println("请输入你想查询的范围：");
            double price = sc.nextDouble();
            for (int i = 0; i < shop1.size(); i++) {
                if ((inform.equals(shop1.get(i).getShopName())) || (inform.equals(shop1.get(i).getAddress()))) {
                    if ((price >= shop1.get(i).getSalePrice()) && choice == 1) {
                        System.out.println("查询成功！");
                        System.out.println("商品编号：" + shop1.get(i).getID() + "  商品名称：" + shop1.get(i).getShopName()
                                + "  生产厂家：" + shop1.get(i).getAddress() + "  生产日期：" + shop1.get(i).getDate() +
                                "  型号：" + shop1.get(i).getSize() + "  进货价：" + shop1.get(i).getInPrice() + "  零售价格："
                                + shop1.get(i).getSalePrice() + "  数量：" + shop1.get(i).getNumbers());
                        bool = true;
                    } else if ((price <= shop1.get(i).getSalePrice()) && choice == 2) {
                        System.out.println("查询成功！");
                        System.out.println("商品编号：" + shop1.get(i).getID() + "  商品名称：" + shop1.get(i).getShopName()
                                + "  生产厂家：" + shop1.get(i).getAddress() + "  生产日期：" + shop1.get(i).getDate() +
                                "  型号：" + shop1.get(i).getSize() + "  进货价：" + shop1.get(i).getInPrice() + "  零售价格："
                                + shop1.get(i).getSalePrice() + "  数量：" + shop1.get(i).getNumbers());
                        bool = true;
                    }
                }
            }
            if (bool == false) {
                System.out.println("未查询到对应商品，查询失败！");
            }
        }
    }
}


