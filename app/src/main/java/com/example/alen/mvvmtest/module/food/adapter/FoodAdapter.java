package com.example.alen.mvvmtest.module.food.adapter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.alen.mvvmtest.R;
import com.example.alen.mvvmtest.app.MyApplication;
import com.example.alen.mvvmtest.module.food.api.bean.FoodItem;
import com.example.common.manager.GlideApp;
import com.example.common.utils.CollectionUtils;
import com.example.common.widget.SquareImageView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 刘伦
 * @date 2018/9/25
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<FoodItem> mList = new ArrayList<>();

    @Inject
    public FoodAdapter() {
    }

    public void setList(List<FoodItem> list) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new FoodItemDiffCallBack(mList, list));
        diffResult.dispatchUpdatesTo(this);
        mList.clear();
        mList.addAll(list);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List payloads) {
        if (payloads == null || payloads.isEmpty()) {
            onBindViewHolder(holder,position);
            return;
        }
        if (!(holder instanceof ViewHolder)) {
            return;
        }
        Bundle bundle = (Bundle) payloads.get(0);
        String content = bundle.getString("title");
        holder.tvFoodName.setText(content);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItem item = getItem(position);
        holder.tvFoodName.setText(item.getTitle());
        if(!CollectionUtils.isEmpty(item.getAlbums())) {
            try {
                GlideApp.with(MyApplication.mContext).load(new URL(item.getAlbums().get(0)))
                        .placeholder(R.mipmap.image_loading_default)
                        .error(R.mipmap.imgfail)
                        .into(holder.ivFoodImg);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    private FoodItem getItem(int pos) {
        if (mList == null || pos < 0 || pos >= mList.size()) {
            return null;
        }
        return mList.get(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_food_img)
        SquareImageView ivFoodImg;
        @BindView(R.id.tv_food_name)
        TextView tvFoodName;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
