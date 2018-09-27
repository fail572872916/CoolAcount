package com.weli.account.mvp.model.presenter;


import com.weli.account.base.BasePresenter;
import com.weli.account.bean.remote.MyUser;

public abstract  class UserInfoPresenter extends BasePresenter {

    public abstract void update(MyUser user);
}
