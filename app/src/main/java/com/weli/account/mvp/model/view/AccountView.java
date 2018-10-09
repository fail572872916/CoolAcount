package com.weli.account.mvp.model.view;

import com.weli.account.base.BaseView;
import com.weli.account.bean.BaseBean;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.bean.remote.Account;

import java.util.List;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account.mvp.model.view
 * @ClassName: AccountView
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/9/28 10:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 10:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface AccountView extends BaseView<BaseBean> {

    void loadDataSuccess(List<LocalAccount> tData);
}
