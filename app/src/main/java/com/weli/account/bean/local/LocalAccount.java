package com.weli.account.bean.local;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.bean.remote
 * @ClassName: LocalAccount
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/27 11:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/27 11:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity
public class LocalAccount {

    @Id(autoincrement = true)
    /**本地id*/
    private Long id;
    /**服务器端id*/
    private String Account;
    private String title;
    private String icon;
    private int type;
    private String pwd;
    private String userid;
    /**创建时间*/
    private long crdate;
    @Generated(hash = 2066236431)
    public LocalAccount(Long id, String Account, String title, String icon,
            int type, String pwd, String userid, long crdate) {
        this.id = id;
        this.Account = Account;
        this.title = title;
        this.icon = icon;
        this.type = type;
        this.pwd = pwd;
        this.userid = userid;
        this.crdate = crdate;
    }

    @Generated(hash = 1589179303)
    public LocalAccount() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return this.Account;
    }
    public void setAccount(String Account) {
        this.Account = Account;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getUserid() {
        return this.userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public long getCrdate() {
        return this.crdate;
    }
    public void setCrdate(long crdate) {
        this.crdate = crdate;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
