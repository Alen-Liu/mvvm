package com.example.alen.mvvmtest.module.food.api.bean;

import com.example.common.net.BaseResultBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/26
 */

public class FoodResultBean extends BaseResultBean {
    @SerializedName("result")
    private FoodResultDataItem result;

    public FoodResultDataItem getResult() {
        return result;
    }

    public void setResult(FoodResultDataItem result) {
        this.result = result;
    }

    public class FoodResultDataItem {
        @SerializedName("data")
        private List<FoodItem> data;
        @SerializedName("totalNum")
        private String totalNum;
        @SerializedName("pn")
        private String pn;
        @SerializedName("rn")
        private String rn;

        public List<FoodItem> getData() {
            return data;
        }

        public void setData(List<FoodItem> data) {
            this.data = data;
        }

        public String getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(String totalNum) {
            this.totalNum = totalNum;
        }

        public String getPn() {
            return pn;
        }

        public void setPn(String pn) {
            this.pn = pn;
        }

        public String getRn() {
            return rn;
        }

        public void setRn(String rn) {
            this.rn = rn;
        }
    }
}
