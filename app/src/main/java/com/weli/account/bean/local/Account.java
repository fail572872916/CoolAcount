package com.weli.account.bean.local;

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


}
