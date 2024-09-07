package ShopSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("------购物系统------\n");
        Manager manager = new Manager();
        Demo demo = new Demo();
        Map<String,Integer> map = new HashMap<>();
        Date date = new Date();
        boolean bool;
        //进入系统
        while (true) {
            System.out.println("欢迎使用购物系统！");
            System.out.println("请选择您的操作！");
            System.out.println("1、管理员登录");
            System.out.println("2、客户登录");
            System.out.println("3、退出系统");
            Scanner sc = new Scanner(System.in);
            int choice1 = sc.nextInt();

            //管理员系统
            //登录(finish)
            if (choice1 == 1) {
                do {
                    System.out.println("请输入账号");
                    String account = sc.next();
                    System.out.println("请输入密码");
                    String password = sc.next();
                    bool = manager.Login(account, password);
                } while (bool == false);
            }
            //登录后(finish)
            while (choice1 == 1) {
                System.out.println("请选择您的操作！");
                System.out.println("1、密码管理");
                System.out.println("2、客户管理");
                System.out.println("3、商品管理");
                System.out.println("4、退出登录");
                int choice2 = sc.nextInt();

                //密码管理(finish)
                while (choice2 == 1) {
                    System.out.println("请选择您的操作！");
                    System.out.println("1、修改自身密码");
                    System.out.println("2、重置客户密码");
                    System.out.println("3、退出密码管理");
                    int choice3 = sc.nextInt();
                    //修改自身密码(finish)
                    while (choice3 == 1) {
                        do {
                            System.out.println("请输入原密码：");
                            String password = sc.next();
                            System.out.println("请输入新密码");
                            String newPassword = sc.next();
                            bool = manager.ChangePassword(password, newPassword);
                        } while (bool == false);
                        break;
                    }
                    //重置客户密码(finish)
                    while (choice3 == 2) {
                        System.out.println("请输入客户账号");
                        String account = sc.next();
                        demo.resetPassword(account);
                        break;
                    }
                    //退出密码管理(finish)
                    if (choice3 == 3) {
                        break;
                    }
                }
                //客户管理(finish)
                while (choice2 == 2) {
                    System.out.println("请选择您的操作！");
                    System.out.println("1、列出所有客户信息");
                    System.out.println("2、删除客户信息");
                    System.out.println("3、查询客户信息");
                    System.out.println("4、退出客户管理");
                    int choice4 = sc.nextInt();
                    //列出所有客户的信息
                    while (choice4 == 1) {
                        for (User u : demo.user1) {
                            System.out.println("用户名：" + u.getAccount() + "  用户注册时间" + u.getTime() + "  用户邮箱" + u.getMail());
                        }
                        break;
                    }
                    //删除客户信息(finish)
                    while (choice4 == 2) {
                        demo.DeleteUser();
                        break;
                    }
                    //查询客户信息(finish)
                    while (choice4 == 3) {
                        demo.FindUserInform();
                        break;
                    }
                    //退出客户管理
                    if (choice4 == 4) {
                        break;
                    }
                }
                inner:
                //商品管理(finish)
                while (choice2 == 3) {
                    System.out.println("请选择您的操作！");
                    System.out.println("1、列出所有商品的信息");
                    System.out.println("2、添加商品的信息");
                    System.out.println("3、修改商品的信息");
                    System.out.println("4、删除商品的信息");
                    System.out.println("5、查询商品的信息");
                    System.out.println("6、退出商品管理");
                    int choice5 = sc.nextInt();
                    //列出所有商品的信息(finish)
                    while (choice5 == 1) {
                        demo.Iter();
                        break;
                    }
                    //添加商品的信息(finish)
                    while (choice5 == 2) {
                        Shop shop = new Shop();
                        shop.addShopInfom();
                        demo.addShop(shop);
                        break;
                    }
                    //修改商品的信息(finish)
                    while (choice5 == 3) {
                        demo.ChangeInform();
                        break;
                    }
                    //删除商品的信息(finish)
                    while (choice5 == 4) {
                        demo.DeleteInform();
                        break;
                    }
                    //查询商品的信息(finish)
                    while (choice5 == 5) {
                        System.out.println("请选择您的查询方式：");
                        System.out.println("1、单独查询");
                        System.out.println("2、组合查询");
                        int n = sc.nextInt();
                        demo.FindInform(n);
                        break;
                    }
                    //退出商品管理(finish)
                    while (choice5 == 6) {
                        break inner;
                    }
                }
                //退出登录(finish)
                if (choice2 == 4) {
                    break;
                }
            }
            //客户系统(finish)
            while (choice1 == 2) {
                System.out.println("请选择您的操作！");
                System.out.println("1、注册");
                System.out.println("2、登录");
                System.out.println("3、退出客户系统");
                int choice6 = sc.nextInt();
                //注册(finish)
                while (choice6 == 1) {
                    User user = new User();
                    System.out.println("请输入邮箱：");
                    String mail = sc.next();
                    do {
                        System.out.println("请输入用户名（账号）：");
                        String account = sc.next();
                        System.out.println("请输入密码：");
                        String password = sc.next();
                        bool = user.register(mail, account, password);
                    } while (bool == false);
                    demo.addUser(user);
                    break;
                }
                inner:
                //登录(finish)
                while (choice6 == 2) {
                    int flag = 0;
                    User user = new User();
                    //user.setMap(0);
                    System.out.println("请输入账号：");
                    String account = sc.next();
                    for (int i = 0; i < demo.user1.size(); i++) {
                        if (demo.user1.get(i).getAccount().equals(account)) {
                            flag = 1;
                            user = demo.user1.get(i);
                        }
                    }
                    if (flag == 0) {
                        System.out.println("未找到此账号！");
                        break;
                    }
                    bool = user.Login(account);
                    if (bool == false) {
                        System.out.println("账号已锁定。");
                        demo.user1.remove(user);
                        break;
                    }
                    //登录成功(finish)
                    while (bool == true) {
                        ShopCart shopCart = new ShopCart();
                        System.out.println("登录成功！");
                        System.out.println("请选择您的操作！");
                        System.out.println("1、密码管理");
                        System.out.println("2、购物");
                        System.out.println("3、退出登录");
                        int choice7 = sc.nextInt();
                        //密码管理(finish)
                        while (choice7 == 1) {
                            System.out.println("请选择您的操作！");
                            System.out.println("1、修改自身密码");
                            System.out.println("2、忘记密码");
                            System.out.println("3、退出密码管理");
                            int choice8 = sc.nextInt();
                            //修改自身密码(finish)
                            while (choice8 == 1) {
                                System.out.println("请输入原密码：");
                                String password = sc.next();
                                if (user.getPassword().equals(password)) {
                                    do {
                                        System.out.println("请输入新密码");
                                        String newPassword = sc.next();
                                        bool = user.ChangePassword(password, newPassword);
                                    } while (bool == false);
                                    break;
                                } else {
                                    System.out.println("密码错误");
                                    break;
                                }
                            }
                            //忘记密码(finish)
                            while (choice8 == 2) {
                                System.out.println("请输入账号：");
                                String account1 = sc.next();
                                System.out.println("请输入注册所用的邮箱：");
                                String mail = sc.next();
                                user.ForgetPassword(account1, mail);
                                break;
                            }
                            //退出密码管理
                            if (choice8 == 3) {
                                break;
                            }
                        }
                        //购物(finish)
                        while (choice7 == 2) {
                            System.out.println("请选择您的操作！");
                            System.out.println("0、查看购物车");
                            System.out.println("1、将商品加入购物车");
                            System.out.println("2、将商品从购物车中移除");
                            System.out.println("3、修改购物车中的商品");
                            System.out.println("4、结账");
                            System.out.println("5、查看购物历史");
                            System.out.println("6、退出购物");
                            int choice9 = sc.nextInt();

                            //查看购物车(finish)
                            while (choice9 == 0) {
                                Set<Shop> keys = shopCart.getShopcart().keySet();
                                System.out.println("购物车：");
                                for (Shop shop : keys) {
                                    Integer value = shopCart.getShopcart().get(shop);
                                    System.out.println("商品："+shop.getShopName()+"   数量："+value);
                                }
                            }
                            //将商品加入购物车(finish)
                            while (choice9 == 1) {
                                System.out.println("请输入商品编号和数量：");
                                String id = sc.next();
                                int nums = sc.nextInt();
                                int flag1 = 0;
                                for (int i = 0; i < demo.shop1.size(); i++) {
                                    if ((demo.shop1.get(i).getID().equals(id))&&(nums<=demo.shop1.get(i).getNumbers())) {
                                        flag1 = 1;
                                        Shop shop = demo.shop1.get(i);
                                        if (shopCart.getShopcart().containsKey(shop))
                                            shopCart.setShopcart(shop, shopCart.getShopcart().get(shop) + nums);
                                        else
                                            shopCart.setShopcart(shop,nums);
                                        System.out.println("添加成功！");
                                        break;
                                    }
                                }
                                if (flag1 == 0) System.out.println("添加失败！");
                                break;
                            }
                            //将商品从购物车中移除(finish)
                            while (choice9 == 2) {
                                System.out.println("请输入要移除的商品编号：");
                                String id = sc.next();
                                int flag2 = 0;
                                for (int i = 0; i < demo.shop1.size(); i++) {
                                    if (demo.shop1.get(i).getID().equals(id)) {
                                        flag2 = 1;
                                        System.out.println(" 请确认是否移除？");
                                        System.out.println("1、是  |  2、否");
                                        int choice = sc.nextInt();
                                        if (choice == 1) {
                                            shopCart.removeShopcart(demo.shop1.get(i));
                                            System.out.println("移除成功！");
                                        } else if (choice == 2) System.out.println("取消移除！");
                                    }
                                }
                                if (flag2 == 0) System.out.println("移除失败！");
                                break;
                            }
                            //修改购物车中的商品(finish)
                            while (choice9 == 3) {
                                System.out.println("请输入想修改的商品编号和修改的数量");
                                String id = sc.next();
                                int nums = sc.nextInt();
                                int flag3 = 0;
                                for (int i = 0; i < demo.shop1.size(); i++) {
                                    if (demo.shop1.get(i).getID().equals(id)) {
                                        flag3 = 1;
                                        Shop shop = demo.shop1.get(i);
                                        shopCart.setShopcart(shop,shopCart.getShopcart().get(shop) + nums);
                                        if (shopCart.getShopcart().get(shop) <= 0) shopCart.removeShopcart(shop);
                                        System.out.println("修改成功！");
                                    }
                                }
                                if (flag3 == 0) System.out.println("修改失败！");
                                break;
                            }
                            //结账(finish)
                            while (choice9 == 4) {
                                map.clear();
                                double totalPrice = 0;
                                for (int i = 0; i < demo.shop1.size(); i++) {
                                    if (shopCart.getShopcart().containsKey(demo.shop1.get(i))) {
                                        totalPrice += demo.shop1.get(i).getSalePrice() * shopCart.getShopcart().get(demo.shop1.get(i));
                                        demo.shop1.get(i).setNumbers(demo.shop1.get(i).getNumbers() - shopCart.getShopcart().get(demo.shop1.get(i)));
                                        map.put(demo.shop1.get(i).getShopName(),shopCart.getShopcart().get(demo.shop1.get(i)));
                                        shopCart.removeShopcart(demo.shop1.get(i));
                                    }
                                }
                                //user.setMap(totalPrice);
                                System.out.println("一共" + totalPrice + "元");
                                System.out.println("------请选择您的支付方式------");
                                System.out.println("1、支付宝 | 2、微信 | 3、银行卡");
                                int choice = sc.nextInt();
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                shopCart.setTime(dateFormat.format(date));
                                if (choice == 1) System.out.println("支付宝支付成功！");
                                else if (choice == 2) System.out.println("微信支付成功！");
                                else if (choice == 3) System.out.println("银行卡支付成功！");
                                break;
                            }
                            //查看购物历史(finish)
                            while (choice9 == 5) {
                                System.out.println("支付时间：" + shopCart.getTime());
                                System.out.println("商品清单：");
                                Set<String> keys = map.keySet();
                                for (String key : keys) {
                                    Integer value = map.get(key);
                                    System.out.println("商品："+key+"   数量"+value);
                                }
                                break;
                            }
                            //退出购物(finish)(待定)
                            if (choice9 == 6) {
                                // shopCart.list.clear();
                                //shopCart.getShopcart().clear();
                                break;
                            }
                        }
                        //退出登录(finish)
                        if (choice7 == 3) {
                            break inner;
                        }
                    }
                }
                //退出客户系统
                if (choice6 == 3) {
                    break;
                }
            }
            //退出系统
            while (choice1 == 3) {
                System.out.println("\n----*----*----*----");
                System.out.println(" 感谢使用本系统，再见！");
                System.out.println("----*----*----*----");
                return;
            }
        }
    }
}
