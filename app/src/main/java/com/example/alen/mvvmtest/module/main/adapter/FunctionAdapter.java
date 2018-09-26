package com.example.alen.mvvmtest.module.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alen.mvvmtest.R;
import com.example.alen.mvvmtest.module.main.bean.FunctionBean;
import com.example.alen.mvvmtest.module.main.callback.FunctionItemClickCallBack;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 刘伦
 * @date 2018/9/17
 * 功能条适配器
 */

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder> {
    /**
     * 功能列表
     */
    List<FunctionBean> mList = new ArrayList<>();

    /**
     * 列表项 点击事件监听器
     */
    FunctionItemClickCallBack mListener;

    @Inject
    public FunctionAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main_function, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FunctionBean bean = getItem(position);
        holder.mTvFuncName.setText(bean.getTitle());
        holder.mTvFuncName.setOnClickListener(v -> {
            if(mListener != null){
                mListener.onItemClicked(getItem(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    private FunctionBean getItem(int pos) {
        if (mList == null || pos < 0 || pos >= mList.size()) {
            return null;
        }
        return mList.get(pos);
    }

    public void setListener(FunctionItemClickCallBack mListener) {
        this.mListener = mListener;
    }

    public void setList(List<FunctionBean> list) {
        this.mList = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_func_name)
        TextView mTvFuncName;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
