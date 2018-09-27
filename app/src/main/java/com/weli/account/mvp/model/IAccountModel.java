package com.weli.account.mvp.model;

import com.weli.account.bean.local.Account;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.mvp.model
 * @ClassName: IAccountModel
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/26 11:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/26 11:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IAccountModel {

    void getAccount(String userid);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);
}
