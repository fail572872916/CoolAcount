package com.weli.account.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weli.account.AccountAdapter;
import com.weli.account.R;
import com.weli.account.bean.BaseBean;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.mvp.model.presenter.IAccountPresenter;
import com.weli.account.mvp.model.presenter.Imp.AccountPresenter;
import com.weli.account.mvp.model.view.AccountView;
import com.weli.account.ui.AddAcountActivity;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AccountFragment extends BaseFragment implements AccountView {


    @BindView(R.id.rec_account_list)
    RecyclerView recAccountList;
    @BindView(R.id.float_btn)
    FloatingActionButton floatBtn;
    Unbinder unbinder;

    AccountAdapter accountAdapter;
    List<LocalAccount> localAccountList;

    IAccountPresenter accountPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initEventAndData() {
        accountPresenter = new AccountPresenter(this);
        recAccountList.setLayoutManager(new LinearLayoutManager(getActivity()));
        recAccountList.addItemDecoration(new DividerItemDecoration(getActivity(), RecyclerView.VERTICAL));
        accountAdapter = new AccountAdapter(localAccountList, getActivity());
        recAccountList.setAdapter(accountAdapter);
        accountPresenter.getAccount();
    }

    @Override
    protected void beforeDestroy() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.float_btn)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), AddAcountActivity.class));
    }


    @Override
    public void loadDataSuccess(BaseBean tData) {

    }

    @Override
    public void loadDataError(Throwable throwable) {

    }

    @Override
    public void loadDataSuccess(List<LocalAccount> tData) {
        localAccountList.clear();
        localAccountList.addAll(tData);
        accountAdapter.notifyDataSetChanged();
    }
}
