package com.example.common.net;

import com.google.gson.annotations.SerializedName;

/**
 * @author 刘伦
 * @date 2018/9/21
 *
 * 请求参数的基础类
 */
@Deprecated
public class BaseRequestBean {
    @SerializedName("key")
    private String key;
    @SerializedName("dtype")
    private String dtype;

    public BaseRequestBean() {
        this.key = NetConstants.JUHE_APP_KEY;
        this.dtype = "json";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }
}
