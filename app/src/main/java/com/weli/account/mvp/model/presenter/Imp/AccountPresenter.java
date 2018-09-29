package com.weli.account.mvp.model.presenter.Imp;

import com.weli.account.bean.BaseBean;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.bean.remote.Account;
import com.weli.account.mvp.model.IAccountModel;
import com.weli.account.mvp.model.Imp.AccountModelImp;
import com.weli.account.mvp.model.presenter.IAccountPresenter;
import com.weli.account.mvp.model.view.AccountView;

import java.util.List;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.mvp.model.presenter.Imp
 * @ClassName: AccountPresenter
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/28 9:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 9:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AccountPresenter extends IAccountPresenter implements AccountModelImp.AccountOnListener {
    IAccountModel iAccountModel;
    AccountView accountView;

    public AccountPresenter( AccountView accountView) {
        this.iAccountModel = new AccountModelImp(this);
        this.accountView = accountView;
    }

    @Override
    public void getAccount() {
        iAccountModel.getAccount();
    }

    @Override
    public void addAccount(LocalAccount account) {
        iAccountModel.addAccount(account);
    }

    @Override
    public void updateAccount(LocalAccount account) {
        iAccountModel.updateAccount(account);
    }

    @Override
    public void delete(Long id) {
        iAccountModel.deleteAccount(id);
    }

    @Override
    public void onSuccess(BaseBean bean) {
        accountView.loadDataSuccess(bean);
    }

    @Override
    public void onSuccess(Account bean) {
        accountView.loadDataSuccess(bean);
    }

    @Override
    public void onFailure(Throwable e) {
        accountView.loadDataError(e);
    }
}
