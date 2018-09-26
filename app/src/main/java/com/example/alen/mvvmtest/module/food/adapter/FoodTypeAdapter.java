package com.example.alen.mvvmtest.module.food.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alen.mvvmtest.R;
import com.example.alen.mvvmtest.module.food.callback.OnFoodTypeClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 刘伦
 * @date 2018/9/21
 * 食物分类适配器
 */

public class FoodTypeAdapter extends RecyclerView.Adapter {
    private List<FoodTypeListBean> mList;
    private OnFoodTypeClickListener mListener;
    private int mLastPos;
    @Inject
    public FoodTypeAdapter() {
    }

    public void setList(List<FoodTypeListBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void setListener(OnFoodTypeClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case FoodTypeListBean.TYPE_GROUP:
                View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_food_type, parent, false);
                viewHolder = new ViewHolder(view);
                break;
            case FoodTypeListBean.TYPE_ITEM:
                View view1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_food_child_type, parent, false);
                viewHolder = new ChildViewHolder(view1);
                break;
            default:break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FoodTypeListBean item = getItem(position);
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).mTvItemFoodTypeName.setText(item.getName());
        } else {
            ((ChildViewHolder) holder).mTvItemFoodChildTypeName.setText(item.getName());
            ((ChildViewHolder) holder).mTvItemFoodChildTypeName.setOnClickListener(v -> {
                int pos = holder.getAdapterPosition();
                if(pos == RecyclerView.NO_POSITION){
                    return;
                }
                if(mListener != null) {
                    mLastPos = pos;
                    mListener.onFoodTypeClicked();
                }
            });
        }
    }

    public int getSelectedCId(){
        if(getItem(mLastPos) != null && getItem(mLastPos).getType() == FoodTypeListBean.TYPE_ITEM) {
            return Integer.parseInt(getItem(mLastPos).getId());
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    private FoodTypeListBean getItem(int pos) {
        if (mList == null || pos < 0 || pos >= mList.size()) {
            return null;
        }
        return mList.get(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_item_food_type_name)
        TextView mTvItemFoodTypeName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.m_tv_item_food_child_type_name)
        TextView mTvItemFoodChildTypeName;

        public ChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
