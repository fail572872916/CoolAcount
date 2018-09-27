package com.weli.account.mvp.model;


import com.weli.account.bean.local.MyUser;

public interface UserInfoModel {

    void update(MyUser user);

    void onUnsubscribe();
}
