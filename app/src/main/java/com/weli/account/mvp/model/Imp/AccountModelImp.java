package com.weli.account.mvp.model.Imp;

import com.weli.account.bean.Account;
import com.weli.account.mvp.model.IAccountModel;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

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

            }
        });

        }

        @Override
        public void addAccount (Account account){

        }

        @Override
        public void updateAccount (Account account){

        }

        @Override
        public void deleteAccount (Account account){

        }

        /**
         * 回调接口
         */
        public interface AccountOnListener {

            void onSuccess(List<Account> bean);

            void onFailure(Throwable e);
        }
    }
