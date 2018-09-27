package com.weli.account.mvp.model.presenter.Imp;


import com.weli.account.bean.remote.MyUser;
import com.weli.account.mvp.model.Imp.UserInfoModelImp;
import com.weli.account.mvp.model.UserInfoModel;
import com.weli.account.mvp.model.presenter.UserInfoPresenter;
import com.weli.account.mvp.model.view.UserInfoView;

public class UserInfoPresenterImp extends UserInfoPresenter implements UserInfoModelImp.UserInfoOnListener {

    private UserInfoModel model;
    private UserInfoView view;

    public UserInfoPresenterImp(UserInfoView view) {
        this.model=new UserInfoModelImp(this);
        this.view = view;
    }

    @Override
    public void onSuccess(MyUser user) {
        view.loadDataSuccess(user);
    }

    @Override
    public void onFailure(Throwable e) {
        view.loadDataError(e);
    }

    @Override
    public void update(MyUser user) {
        model.update(user);
    }
}
