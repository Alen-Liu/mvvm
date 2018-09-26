package com.example.alen.mvvmtest.module.food;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alen.mvvmtest.MyBaseActivity;
import com.example.alen.mvvmtest.R;
import com.example.alen.mvvmtest.module.food.adapter.FoodAdapter;
import com.example.alen.mvvmtest.module.food.adapter.FoodTypeAdapter;
import com.example.alen.mvvmtest.module.food.adapter.FoodTypeListBean;
import com.example.alen.mvvmtest.module.food.callback.OnFoodTypeClickListener;
import com.example.common.irecyclerview.IRecyclerView;
import com.example.common.irecyclerview.LoadMoreFooterView;
import com.example.common.irecyclerview.OnLoadMoreListener;
import com.example.common.irecyclerview.OnRefreshListener;
import com.example.common.widget.CommonToast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 刘伦
 * @date 2018/9/21
 * <p>
 * 菜谱大全
 */

public class FoodActivity extends MyBaseActivity implements OnFoodTypeClickListener, OnLoadMoreListener, OnRefreshListener {
    @BindView(R.id.m_rv_food_type_list)
    RecyclerView mRvFoodTypeList;
    @BindView(R.id.m_rv_food_list)
    IRecyclerView mRvFoodList;
    @Inject
    FoodTypeAdapter mTypeAdapter;
    @Inject
    FoodActivityViewModule viewModule;

    @Inject
    FoodAdapter mFoodAdapter;
    private LoadMoreFooterView loadMoreFooterView;

    public static void launch(Context context) {
        Intent intent = new Intent(context, FoodActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvFoodTypeList.setLayoutManager(layoutManager);
        mRvFoodTypeList.setAdapter(mTypeAdapter);
        mTypeAdapter.setListener(this);

        GridLayoutManager layoutManager1 = new GridLayoutManager(this, 4);
        mRvFoodList.setLayoutManager(layoutManager1);
        mRvFoodList.setIAdapter(mFoodAdapter);
        mRvFoodList.setOnLoadMoreListener(this);
        mRvFoodList.setOnRefreshListener(this);
        loadMoreFooterView = (LoadMoreFooterView) mRvFoodList.getLoadMoreFooterView();

    }

    private void initData() {
        viewModule.requestTypeList().observe(this, foodTypeObserver);
    }

    /**
     * 请求食物列表监听器
     */
    private Observer<Boolean> foodListObserver = result -> {
        stopLoadMoreAndRefresh();
        if(result){
            mFoodAdapter.setList(viewModule.getFoodList());
        } else {
            CommonToast.showShort(R.string.str_food_list_request_fail);
        }
    };


    /**
     * 请求食物种类列表监听器
     */
    private Observer<List<FoodTypeListBean>> foodTypeObserver = foodTypeListBeans -> {
        mTypeAdapter.setList(foodTypeListBeans);
        viewModule.getFoodByType(mTypeAdapter.getSelectedCId(), true).observe(
                FoodActivity.this, foodListObserver);
    };

    @Override
    public void onFoodTypeClicked() {
        viewModule.getFoodByType(mTypeAdapter.getSelectedCId(), true);
    }

    public void stopLoadMoreAndRefresh() {
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        mRvFoodList.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {
        if (loadMoreFooterView.canLoadMore()) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
            viewModule.getFoodByType(mTypeAdapter.getSelectedCId(), false);
        }
    }

    @Override
    public void onRefresh() {
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        viewModule.getFoodByType(mTypeAdapter.getSelectedCId(), true);
    }
}
