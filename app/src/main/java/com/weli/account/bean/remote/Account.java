package com.weli.account.bean.remote;

import com.weli.account.bean.local.LocalAccount;

import cn.bmob.v3.BmobObject;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.bean
 * @ClassName: Account
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/26 11:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/26 11:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Account extends BmobObject {
    private String Account;
    private String title;
    private String icon;
    private int type;
    private String userid;
    private String pwd;

    public Account(String account, String title, String icon, int type, String userid) {
        Account = account;
        this.title = title;
        this.icon = icon;
        this.type = type;
        this.userid = userid;
    }


    public Account(String tableName, String account, String title, String icon, int type, String userid) {
        super(tableName);
        Account = account;
        this.title = title;
        this.icon = icon;
        this.type = type;
        this.userid = userid;
    }

    public Account(LocalAccount tableName) {
        this.Account = tableName.getAccount();
        this.icon = tableName.getIcon();
        this.title = tableName.getTitle();
        this.type = tableName.getType();
        this.userid = tableName.getUserid();
        this.pwd = tableName.getPwd();
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
