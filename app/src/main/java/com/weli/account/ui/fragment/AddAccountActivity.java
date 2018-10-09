package com.weli.account.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Spinner;

import com.weli.account.R;
import com.weli.account.bean.BaseBean;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.bean.remote.Account;
import com.weli.account.mvp.model.presenter.IAccountPresenter;
import com.weli.account.mvp.model.presenter.Imp.AccountPresenter;
import com.weli.account.mvp.model.view.AccountView;
import com.weli.account.ui.BaseActivity;
import com.weli.account.utils.SnackbarUtils;
import com.weli.account.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class AddAccountActivity extends BaseActivity implements AccountView {
    IAccountPresenter presenter;
    @BindView(R.id.til_username)
    TextInputLayout tilUsername;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;

    @BindView(R.id.til_title)
    TextInputLayout tilTitle;
    @BindView(R.id.spinner_account_type)
    AppCompatSpinner spinnerAccountType;
    private EditText mEdtAccount;
    private EditText mEdtPwd;
    private EditText mETitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_add_account;
    }

    @Override
    protected void initEventAndData() {
        presenter = new AccountPresenter(this);
        mEdtAccount = tilUsername.getEditText();
        mEdtAccount = tilUsername.getEditText();
        mEdtPwd = tilPassword.getEditText();
        mETitle = tilTitle.getEditText();

        mEdtAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tilUsername.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    public void loadDataSuccess(Account tData) {
        SnackbarUtils.show(this,"1111");
    }

    @Override
    public void loadDataSuccess(BaseBean tData) {
        SnackbarUtils.show(this,"222222");
    }

    @Override
    public void loadDataError(Throwable throwable) {

        SnackbarUtils.show(this,throwable.getMessage());
    }

    @OnClick(R.id.btn_finish)
    public void onViewClicked() {
        String account = mEdtAccount.getText().toString();
        String pwd = mEdtPwd.getText().toString();
        String title = mETitle.getText().toString();
        int type = spinnerAccountType.getSelectedItemPosition();
        if (TextUtils.isEmpty(account)) {
            ToastUtils.show(mContext, "请输入正确的验证码");
        } else if (TextUtils.isEmpty(account)) {
            ToastUtils.show(mContext, "请输入正确的密码");

        } else {
            LocalAccount account1 = new LocalAccount();
            account1.setAccount(account);
            account1.setPwd(pwd);
            account1.setTitle(title);
            account1.setType(type);
            presenter.addAccount(account1);
        }

    }
}
