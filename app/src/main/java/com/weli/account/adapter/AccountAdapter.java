package com.weli.account.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weli.account.R;
import com.weli.account.bean.local.LocalAccount;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: CoolAcount
 * @Package: com.weli.account
 * @ClassName: AccountAdapter
 * @Description: java类作用描述
 * @Author: WeLi
 * @CreateDate: 2018/10/9 11:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/9 11:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder> {
    private List<LocalAccount> lists;
    private Context mContext;

    public AccountAdapter(List<LocalAccount> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_account, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//holder.imAccountPhoto
        holder.tvItemAccount.setText(lists.get(position).getAccount());
        holder.tvItemPwd.setText(lists.get(position).getPwd());
        holder.tvTitle.setText(lists.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.im_account_photo)
        ImageView imAccountPhoto;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_account)
        TextView tvItemAccount;
        @BindView(R.id.tv_item_pwd)
        TextView tvItemPwd;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
