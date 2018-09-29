package com.weli.account.mvp.model.Imp;

import com.weli.account.base.BaseObserver;
import com.weli.account.bean.BaseBean;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.bean.remote.Account;
import com.weli.account.bean.repository.LocalRepository;
import com.weli.account.mvp.model.IAccountModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.mvp.model.Imp
 * @ClassName: AccountModelImp
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/26 12:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/26 12:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AccountModelImp implements IAccountModel {

    private AccountOnListener listener;

    public AccountModelImp(AccountOnListener listener) {
        this.listener = listener;
    }

    @Override
    public void getAccount() {
        final LocalAccount note = new LocalAccount();
    }

    @Override
    public void addAccount(LocalAccount account) {
        LocalRepository.getInstance().saveBBill(account)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LocalAccount>() {
                    @Override
                    protected void onSuccees(LocalAccount bBill) throws Exception {
                        listener.onSuccess(new BaseBean());
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        listener.onFailure(e);
                    }
                });
    }

    @Override
    public void updateAccount(LocalAccount account) {
        LocalRepository.getInstance().updateBBill(account)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LocalAccount>() {
                    @Override
                    protected void onSuccees(LocalAccount bBill) throws Exception {
                        listener.onSuccess(new BaseBean());
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        listener.onFailure(e);
                    }
                });
    }
    @Override
    public void deleteAccount(Long id) {
        LocalRepository.getInstance()
                .deleteBBillById(id);
    }

    /**
     * 回调接口
     */
    public interface AccountOnListener {
        void onSuccess(BaseBean bean);

        void onSuccess(Account bean);

        void onFailure(Throwable e);
    }
}
