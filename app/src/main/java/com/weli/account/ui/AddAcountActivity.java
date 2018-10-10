package com.weli.account.ui;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatSpinner;

import com.weli.account.R;

import butterknife.BindView;

public class AddAcountActivity extends BaseActivity {

    @BindView(R.id.til_title)
    TextInputLayout tilTitle;
    @BindView(R.id.til_username)
    TextInputLayout tilUsername;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.spinner_account_type)
    AppCompatSpinner spinnerAccountType;



    @Override
    protected int getLayout() {
        return R.layout.activity_add_account;
    }

    @Override
    protected void initEventAndData() {

    }


}
