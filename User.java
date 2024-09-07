package ShopSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class User{
    private String Account;
    private String Password;
    private String Mail;
    private String Time;

    //构造函数
    public User() {
    }

    Scanner sc = new Scanner(System.in);

    //用户注册(finish)
    public boolean register(String mail, String account, String password) {
        boolean Letter = false, letter = false, number = false, mark = false;
        if (account.length() >= 5 && password.length() > 8) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    Letter = true;
                }
                if (ch >= 'a' && ch <= 'z') {
                    letter = true;
                }
                if (ch >= '0' && ch <= '9') {
                    number = true;
                }
                if ((ch > ' ' && ch < '0') || (ch > '9' && ch < 'A') || (ch > 'Z' && ch < 'a') || ch > 'z') {
                    mark = true;
                }
            }
            if (Letter && letter && number && mark) {
                System.out.println("注册成功!");
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Mail = mail;
                Account = account;
                Password = password;
                Time = dateFormat.format(date);
                return true;
            } else {
                System.out.println("密码组成不符合要求，请重新修改！");
                return false;
            }
        } else {
            System.out.println("账号或密码长度不符合要求，请重新输入！");
            return false;
        }
    }

    //用户登录(finish)
    public boolean Login(String account) {
        int n = 5;
        while (n > 0) {
            System.out.println("请输入密码：");
            String password = sc.next();
            if (Password.equals(password)) {
                return true;
            } else if (!Password.equals(password)) {
                n--;
                System.out.println("密码错误！");
                System.out.println("还有" + n + "次机会。");
            }
        }
        return false;
    }

    //修改自身密码(finish)
    public boolean ChangePassword(String password, String newPassword) {
        boolean Letter = false, letter = false, number = false, mark = false;
        if (password.equals(Password)) {
            if (newPassword.length() > 8) {
                for (int i = 0; i < newPassword.length(); i++) {
                    char ch = newPassword.charAt(i);
                    if (ch >= 'A' && ch <= 'Z') {
                        Letter = true;
                    } else if (ch >= 'a' && ch <= 'z') {
                        letter = true;
                    } else if (ch >= '0' && ch <= '9') {
                        number = true;
                    } else if ((ch > ' ' && ch < '0') || (ch > '9' && ch < 'A') || (ch > 'Z' && ch < 'a') || ch > 'z') {
                        mark = true;
                    }
                }
                if (Letter && letter && number && mark) {
                    Password = newPassword;
                    System.out.println("修改成功!");
                    return true;
                } else {
                    System.out.println("密码组成不符合要求，请重新修改！");
                    return false;
                }
            } else {
                System.out.println("密码长度过短，请重新输入！");
                return false;
            }

        } else {
            System.out.println("原密码错误，修改失败！");
            return false;
        }
    }

    //忘记密码(finish)
    public boolean ForgetPassword(String account, String mail) {
        if (mail.equals(Mail) && account.equals(Account)) {
            String uuid = UUID.randomUUID().toString().replaceAll(" ", "");
            String Uuid = uuid.substring(0, 8);
            Password = Uuid;
            System.out.println("已将新密码发送至邮箱，请查收！");
            System.out.println("您可以使用新密码“" + Uuid + "”来登录。");
            return true;
        } else {
            System.out.println("账号或邮箱错误！");
            return false;
        }
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}

