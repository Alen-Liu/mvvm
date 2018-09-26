package com.example.common.net;

import com.google.gson.annotations.SerializedName;

/**
 * @author 刘伦
 * @date 2018/9/21
 * 网络请求结果基础类
 */

public class BaseResultBean {
    public static final int RESULT_SUCCESS = 0;

    @SerializedName("resultcode")
    private String resultcode;
    @SerializedName("reason")
    private String reason;
    @SerializedName("error_code")
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
