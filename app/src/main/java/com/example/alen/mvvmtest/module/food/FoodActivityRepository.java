package com.example.alen.mvvmtest.module.food;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import com.example.alen.mvvmtest.BaseRepository;
import com.example.alen.mvvmtest.module.food.adapter.FoodTypeListBean;
import com.example.alen.mvvmtest.module.food.api.FoodApi;
import com.example.alen.mvvmtest.module.food.api.FoodTypeRequestBean;
import com.example.alen.mvvmtest.module.food.api.bean.FoodCategoryItem;
import com.example.alen.mvvmtest.module.food.api.bean.FoodItem;
import com.example.alen.mvvmtest.module.food.api.bean.FoodTypeItem;
import com.example.common.net.BaseResultBean;
import com.example.common.utils.CollectionUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author 刘伦
 * @date 2018/9/25
 */

public class FoodActivityRepository extends BaseRepository {
    private MutableLiveData<List<FoodTypeListBean>> foodTypeLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> foodRequestLiveData = new MutableLiveData<>();
    private List<FoodItem> mFoodList = new ArrayList<>();
    private FoodApi mFoodApi;
    private int pn =0;
    private static final int PAGE_SIZE = 30;

    public FoodActivityRepository(FoodApi foodApi) {
        this.mFoodApi = foodApi;
    }

    @Override
    public void release() {

    }

    /**
     * 请求菜品分类数据
     * @return 菜品分类liveData
     */
    public LiveData<List<FoodTypeListBean>> requestTypeList() {
        mFoodApi.getFoodType().map((response) -> {
            List<FoodTypeListBean> types = new ArrayList<>();
            if (response.getError_code() == BaseResultBean.RESULT_SUCCESS) {
                if (response.getResult() != null && response.getResult().size() > 0) {
                    for (FoodCategoryItem categoryItem : response.getResult()) {
                        types.add(new FoodTypeListBean(categoryItem.getParentId(),
                                categoryItem.getName(), categoryItem.getParentId(), FoodTypeListBean.TYPE_GROUP));
                        if (!CollectionUtils.isEmpty(categoryItem.getList())) {
                            for (FoodTypeItem item : categoryItem.getList()) {
                                types.add(new FoodTypeListBean(item.getParentId(),
                                        item.getName(), item.getId(), FoodTypeListBean.TYPE_ITEM));
                            }
                        }
                    }

                }
            }
            return types;
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    if(!CollectionUtils.isEmpty(list)){
                        foodTypeLiveData.setValue(list);
                    }
                });
        return foodTypeLiveData;
    }

    public List<FoodItem> getFoodList() {
        return mFoodList;
    }

    /**
     * 请求食物列表数据   分页加载
     * @param cid 食物分类id
     * @param isRefresh  是否是刷新
     * @return  是否请求成功  0 成功， 1 失败 ， 2 无更多数据
     */
    public LiveData<Boolean> getFoodByType(int cid, boolean isRefresh) {
        if(cid == 0) {
            return foodRequestLiveData;
        }
        if(isRefresh){
            pn = 0;
        } else {
            pn++;
        }
        mFoodApi.getFoodIndex(cid, String.valueOf(pn), String.valueOf(PAGE_SIZE)).map((response) -> {
            if (response.getError_code() == BaseResultBean.RESULT_SUCCESS) {
                if (response.getResult() != null && response.getResult().getData().size()> 0) {
                    return response.getResult().getData();
                }
            }
            return null;
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    if(list == null){
                        foodRequestLiveData.setValue(false);
                    } else {
                        if(pn == 0) {
                            mFoodList.clear();
                        }
                        mFoodList.addAll(list);
                        foodRequestLiveData.setValue(true);
                    }
                });
        return foodRequestLiveData;
    }
}
