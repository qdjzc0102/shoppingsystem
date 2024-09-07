package ShopSystem;

public class Manager{
    private String Account;
    private String Password;

    //构造函数
    public Manager() {
        Account = "admin";
        Password = "ynuinfo#777";
    }

    //管理员登录
    public boolean Login(String account, String password) {
        if (account.equals(Account) && password.equals(Password)) {
            System.out.println("登录成功!");
            return true;
        } else {
            System.out.println("账号或密码错误!");
            return false;
        }
    }

    //修改自身密码
    public boolean ChangePassword(String password, String newPassword) {
        if (password.equals(Password)) {
            Password = newPassword;
            System.out.println("修改成功!");
            return true;
        } else {
            System.out.println("原密码错误，修改失败！");
            return false;
        }
    }

    //获得账号
    public String getAccount() {
        return Account;
    }

    //获得密码
    public String getPassword() {
        return Password;
    }
}

