package com.weli.account.mvp.model.Imp;
import android.util.Log;
import com.weli.account.bean.BaseBean;
import com.weli.account.bean.remote.Account;
import com.weli.account.mvp.model.IAccountModel;
import java.util.List;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
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
    public void getAccount(String userid) {
        BmobQuery<Account> query = new BmobQuery<Account>();
        //按照时间降序
        query.addWhereContains("userid", userid);
        query.order("-createdAt");
        //执行查询，第一个参数为上下文，第二个参数为查找的回调
        query.findObjects(new FindListener<Account>() {
            @Override
            public void done(List<Account> list, BmobException e) {
                if (e == null) {
                    Log.i("bmob", "查询成功：共" + list.size() + "条数据。");
                    listener.onSuccess(list);
                } else {
                    listener.onFailure(e);
                    Log.i("bmob", "失败：" + e.getMessage());
                }
            }
        });

    }

    @Override
    public void addAccount(Account account) {

        account.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {

                    listener.onSuccess(new BaseBean());
                    Log.i("bmob", "创建数据成功：" + e.getMessage() + "," + e.getErrorCode());


                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                    listener.onFailure(e);
                }
            }
        });
    }

    @Override
    public void updateAccount(Account account) {
        account.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    listener.onSuccess(new BaseBean());
                    Log.i("bmob", "更新成功");
                } else {
                    listener.onFailure(e);
                    Log.i("bmob", "更新失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }

    @Override
    public void deleteAccount(Account account) {

        account.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    listener.onSuccess(new BaseBean());
                    Log.i("bmob", "删除成功");
                } else {
                    listener.onFailure(e);
                    Log.i("bmob", "删除失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }

    /**
     * 回调接口
     */
    public interface AccountOnListener {
        void onSuccess(BaseBean bean);

        void onSuccess(List<Account> bean);

        void onFailure(Throwable e);
    }
}
