package com.weli.account.mvp.model.Imp;

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

//        account.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if (e == null) {
//
//                    listener.onSuccess(new BaseBean());
//                    Log.i("bmob", "创建数据成功：" + e.getMessage() + "," + e.getErrorCode());
//
//
//                } else {
//                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
//                    listener.onFailure(e);
//                }
//            }
//        });
    }

    @Override
    public void updateAccount(LocalAccount account) {
//        account.update(new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if (e == null) {
//                    listener.onSuccess(new BaseBean());
//                    Log.i("bmob", "更新成功");
//                } else {
//                    listener.onFailure(e);
//                    Log.i("bmob", "更新失败：" + e.getMessage() + "," + e.getErrorCode());
//                }
//            }
//        });
    }

    @Override
    public void deleteAccount(Long id) {

//        account.delete(new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if (e == null) {
//                    listener.onSuccess(new BaseBean());
//                    Log.i("bmob", "删除成功");
//                } else {
//                    listener.onFailure(e);
//                    Log.i("bmob", "删除失败：" + e.getMessage() + "," + e.getErrorCode());
//                }
//            }
//        });
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
