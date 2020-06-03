package com.example.venturuscatviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataRequest {

    private boolean success;

    private Integer status;

    @SerializedName("data")
    private List<CatRequest> catRequestList = new ArrayList<>();

    public DataRequest() {
    }

    public DataRequest(boolean success, Integer status, List<CatRequest> catRequestList) {
        this.success = success;
        this.status = status;
        this.catRequestList = catRequestList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<CatRequest> getCatRequestList() {
        return catRequestList;
    }

    public void setCatRequestList(List<CatRequest> catRequestList) {
        this.catRequestList = catRequestList;
    }
}
