package com.weli.account.mvp.model.presenter;

import com.weli.account.base.BasePresenter;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.bean.remote.Account;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.mvp.model.presenter
 * @ClassName: IAccountPresenter
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/28 9:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 9:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class IAccountPresenter extends BasePresenter {


    /**
     * 获取信息
     */
    public abstract void getAccount();

    /**
     * 添加账单
     */
    public abstract void addAccount(LocalAccount bBill);

    /**
     * 修改账单
     */
    public abstract void updateAccount(LocalAccount bBill);


    /**
     * 删除账单
     */
    public abstract void delete(Long id);
}
